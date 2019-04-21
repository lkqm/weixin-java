package com.mario6.weixin.springboot.gateway.core;

import com.mario6.weixin.springboot.gateway.model.WxXmlMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 路由分发
 *
 * @author Mario Luo
 * @date 2019.01.03 09:38
 */
@Slf4j
public class WxRouter {

    private final List<WxRouteRule> rules = new ArrayList<>();

    private ExecutorService executorService;

    private static int DEFAULT_THREAD_POOL_SIZE = 100;

    public WxRouter() {
        this.executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);
    }

    public void route(final String xml) {
        final WxXmlMessage wxMessage = WxXmlMessage.fromXml(xml);
        final List<WxRouteRule> matchRules = new ArrayList<>();
        for (final WxRouteRule rule : this.rules) {
            if (rule.test(wxMessage)) {
                matchRules.add(rule);
            }
        }
        if (matchRules.size() == 0) {
            log.info("Can't find handler for message: \n{}", xml);
            return;
        }

        // 异步执行
        final List<Future<?>> futures = new ArrayList<>();
        for (final WxRouteRule rule : matchRules) {
            final WxRouteHandler handler = rule.getHandler();
            if (handler == null) {
                log.warn("Illegal WxRouteRule, handler can't be null");
                continue;
            }
            Future<?> future = this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    handler.handle(wxMessage);
                }
            });
            futures.add(future);
        }

        // 记录执行结果
        if (futures.size() > 0) {
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (Future<?> future : futures) {
                        try {
                            future.get();
                            log.info("End session access: fromUserName={}",
                                    wxMessage.getFromUserName());
                        } catch (InterruptedException e) {
                            log.error("Error happened when wait task finish", e);
                            Thread.currentThread().interrupt();
                        } catch (ExecutionException e) {
                            log.error("Error happened when wait task finish", e);
                        }
                    }
                }
            });
        }
    }

    /**
     * 开始一个新的Route规则
     */
    public WxRouteRule rule() {
        return new WxRouteRule(this);
    }

    /**
     * 添加一个规则
     */
    public void addRule(WxRouteRule rule) {
        if (rule != null) {
            this.rules.add(rule);
        }
    }
}
