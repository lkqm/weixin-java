package com.mario6.weixin.gateway.core;

import com.mario6.weixin.gateway.base.WxXmlMessage;
import com.mario6.weixin.gateway.core.util.WxMessageUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 路由分发
 */
@Slf4j
public class WxRouter {

    private final List<WxRouteRule> rules = new ArrayList<>();

    private ExecutorService executorService;

    private static int DEFAULT_THREAD_POOL_SIZE = 100;

    public WxRouter() {
        this.executorService = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE, new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable task) {
                return new Thread(task, "pool-wx-router-" + threadNumber.getAndIncrement());
            }
        });
    }

    public void route(final String xml) {
        WxXmlMessage wxMessage = WxMessageUtils.createFromXml(xml);
        List<WxRouteRule> matchRules = getMatchRules(wxMessage);
        if (matchRules.size() == 0) {
            log.info("Can't find handler for message: \n{}", xml);
            return;
        }
        List<Future<?>> futures = executeRules(wxMessage, matchRules);
        recordFutureTask(wxMessage, futures);
    }


    private List<WxRouteRule> getMatchRules(WxXmlMessage wxMessage) {
        List<WxRouteRule> matchRules = new ArrayList<>();
        for (final WxRouteRule rule : this.rules) {
            if (rule.test(wxMessage)) {
                matchRules.add(rule);
            }
        }
        return matchRules;
    }

    private List<Future<?>> executeRules(final WxXmlMessage wxMessage, List<WxRouteRule> matchRules) {
        List<Future<?>> futures = new ArrayList<>();
        for (final WxRouteRule rule : matchRules) {
            final WxHandler handler = rule.getHandler();
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

        return futures;
    }

    private void recordFutureTask(final WxXmlMessage wxMessage, final List<Future<?>> futureTasks) {
        if (futureTasks.size() == 0) return;
        this.executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (Future<?> future : futureTasks) {
                    try {
                        future.get();
                        log.debug("End session access: fromUserName={}", wxMessage.getFromUserName());
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
