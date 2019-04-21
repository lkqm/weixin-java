package com.mario6.springboot.weixin.gateway.core;

import com.mario6.springboot.weixin.gateway.annotation.WxEvent;
import com.mario6.springboot.weixin.gateway.annotation.WxMessage;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * 路由注册
 *
 * @author Mario Luo
 * @date 2019.01.03 13:37
 */
@Slf4j
public class WxRouterRegister {

    private WxRouter router;

    private WxRouterRegister(WxRouter router) {
        this.router = router;
    }

    public static WxRouterRegister create(WxRouter router) {
        return new WxRouterRegister(router);
    }

    public void registry(Collection<Object> values) {
        Iterator<Object> it = values.iterator();
        while (it.hasNext()) {
            Object invoker = it.next();
            Class<?> clazz = invoker.getClass();
            if (clazz.isInterface()) continue;
            registryForInvoker(invoker);
        }
    }

    private void registryForInvoker(Object invoker) {
        Class<?> clazz = invoker.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            WxEvent wxEvent = method.getAnnotation(WxEvent.class);
            WxMessage wxMessage = method.getAnnotation(WxMessage.class);
            if (wxEvent == null && wxMessage == null) continue;

            // 重复注解@WxEvent, @WxMessage
            String methodName = method.toString();
            if (wxEvent != null && wxMessage != null) {
                throw new RuntimeException("微信路由注册失败, 找到重复注解@WxEvent,@WxMessage: " + methodName);
            }

            if (wxEvent != null) {
                doRegistryEvent(invoker, method, wxEvent);
            } else {
                doRegistryMessage(invoker, method, wxMessage);
            }
        }
    }


    private void doRegistryEvent(Object invoker, Method method, WxEvent wxEvent) {
        WxRouteHandler handler = WxRouteHandler.create(invoker, method);
        String event = wxEvent.value();
        router.rule().msgType("event").event(event).handler(handler).next();

        String methodName = method.toString();
        log.info("注册微信事件处理方法(event={}): {}", event, methodName);
    }

    private void doRegistryMessage(Object invoker, Method method, WxMessage wxMessage) {
        WxRouteHandler handler = WxRouteHandler.create(invoker, method);
        String msgType = wxMessage.msgType();
        String content = wxMessage.content();
        String contentRegex = wxMessage.contentRegex();
        router.rule().msgType(msgType).content(content).contentRegex(contentRegex).handler(handler).next();

        String methodName = method.toString();
        log.info("注册微信消息处理方法(msgType={}, content={}, contentRegex={}): {}", msgType, content, contentRegex, methodName);
    }
}
