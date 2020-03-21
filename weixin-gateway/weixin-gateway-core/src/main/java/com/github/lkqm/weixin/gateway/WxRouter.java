package com.github.lkqm.weixin.gateway;

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

    public void route(final Message message) {
        List<WxRouteRule> matchRules = getMatchRules(message);
        if (matchRules.size() == 0) {
            log.info("Can't find handler for message: \n{}", message.getXml());
            return;
        }
        List<Future<?>> futures = executeRules(message, matchRules);
        recordFutureTask(message, futures);
    }


    private List<WxRouteRule> getMatchRules(Message message) {
        List<WxRouteRule> matchRules = new ArrayList<>();
        for (final WxRouteRule rule : this.rules) {
            if (rule.test(message)) {
                matchRules.add(rule);
            }
        }
        return matchRules;
    }

    private List<Future<?>> executeRules(final Message message, List<WxRouteRule> matchRules) {
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
                    handler.handle(message);
                }
            });
            futures.add(future);
        }

        return futures;
    }

    private void recordFutureTask(final Message wxMessage, final List<Future<?>> futureTasks) {
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
