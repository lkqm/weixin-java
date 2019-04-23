package com.mario6.weixin.gateway.core;

import com.mario6.weixin.gateway.core.annotation.WxEvent;
import com.mario6.weixin.gateway.core.annotation.WxMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 路由注册
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
        log.info("开始注册微信路由...");
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
            if (wxEvent != null && wxMessage != null) {
                String methodName = getFullMethodName(method);
                throw new RuntimeException("微信路由注册失败, 不能同时注解@WxEvent和@WxMessage: " + methodName);
            }

            if (wxEvent != null) {
                doRegistryEvent(invoker, method, wxEvent);
            } else {
                doRegistryMessage(invoker, method, wxMessage);
            }
        }
    }


    private void doRegistryEvent(Object invoker, Method method, WxEvent wxEvent) {
        WxHandler handler = WxHandler.create(invoker, method);
        String event = wxEvent.value();
        router.rule().msgType("event").event(event).handler(handler).next();

        String methodName = getFullMethodName(method);
        log.info("微信路由注册[event={}]: {}", event, methodName);
    }

    private void doRegistryMessage(Object invoker, Method method, WxMessage wxMessage) {
        WxHandler handler = WxHandler.create(invoker, method);
        String msgType = wxMessage.msgType();
        router.rule().msgType(msgType).handler(handler).next();

        String methodName = getFullMethodName(method);
        log.info("微信路由注册[msgType={}]: {}", msgType, methodName);
    }

    private String getFullMethodName(Method method) {
        String className = method.getDeclaringClass().getCanonicalName();
        String methodName = method.getName();
        Class<?>[] types = method.getParameterTypes();
        List<String> typeNames = new ArrayList<>(types.length);
        for (Class type : types) {
            typeNames.add(type.getSimpleName());
        }
        String fullMethodName = new StringBuilder()
                .append(className)
                .append(".").append(methodName)
                .append("(").append(StringUtils.join(typeNames, ","))
                .append(")")
                .toString();
        return fullMethodName;
    }
}
