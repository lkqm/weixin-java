package com.mario6.weixin.gateway.core;

import com.mario6.weixin.gateway.core.annotation.WxEvent;
import com.mario6.weixin.gateway.core.annotation.WxMessage;
import com.mario6.weixin.gateway.core.exception.WxRouterRegistryException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 路由注册
 */
@Slf4j
public class WxRouterRegister {

    private WxRouter router;

    private Map<String, Method> registeredMessages = new CaseInsensitiveMap();
    private Map<String, Method> registeredEvents = new CaseInsensitiveMap();

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
            registryInvoker(invoker);
        }
    }

    private void registryInvoker(Object invoker) {
        Class<?> clazz = invoker.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            WxEvent wxEvent = method.getAnnotation(WxEvent.class);
            WxMessage wxMessage = method.getAnnotation(WxMessage.class);
            if (wxEvent == null && wxMessage == null) continue;

            // 重复注解@WxEvent, @WxMessage
            if (wxEvent != null && wxMessage != null) {
                String methodName = getFullMethodName(method);
                throw new WxRouterRegistryException("微信路由注册失败, 处理方法不能同时注解@WxEvent和@WxMessage: " + methodName);
            }

            if (wxEvent != null) {
                registryEvent(invoker, method, wxEvent);
            } else {
                registryMessage(invoker, method, wxMessage);
            }
        }
    }

    private void registryEvent(Object invoker, Method method, WxEvent wxEvent) {
        String methodName = getFullMethodName(method);
        String event = wxEvent.value();
        Method eventMethod = registeredEvents.get(event);
        if (eventMethod != null) {
            throw new WxRouterRegistryException("微信路由注册失败, 重复的事件处理方法: " + methodName + " ," + getFullMethodName(eventMethod) + " ");
        }

        WxHandler handler = WxHandler.create(invoker, method);
        router.rule().msgType("event").event(event).handler(handler).next();
        registeredEvents.put(event, method);
        log.info("微信路由注册[event={}]: {}", event, methodName);
    }

    private void registryMessage(Object invoker, Method method, WxMessage wxMessage) {
        String msgType = wxMessage.value();
        String methodName = getFullMethodName(method);
        if ("event".equalsIgnoreCase(msgType)) {
            throw new WxRouterRegistryException("微信路由注册失败，@WxMessage的value不能是event: " + methodName);
        }

        Method orgMessageMethod = registeredMessages.get(msgType);
        if (orgMessageMethod != null) {
            throw new WxRouterRegistryException("微信路由注册失败, 重复的消息处理方法: " + methodName + " ," + getFullMethodName(orgMessageMethod) + " ");
        }

        WxHandler handler = WxHandler.create(invoker, method);
        router.rule().msgType(msgType).handler(handler).next();
        registeredMessages.put(msgType, method);
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
