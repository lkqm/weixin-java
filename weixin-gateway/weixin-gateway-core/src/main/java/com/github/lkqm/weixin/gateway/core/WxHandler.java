package com.github.lkqm.weixin.gateway.core;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 微信消息处理器, 封装具体的消息处理方法
 */
public class WxHandler {

    private Object invoker;
    private Method method;

    public static WxHandler create(Object invoker, Method method) {
        return new WxHandler(invoker, method);
    }

    private WxHandler(Object invoker, Method method) {
        if (invoker == null) {
            throw new IllegalArgumentException("Argument 'invoker' must not be null");
        }
        if (method == null) {
            throw new IllegalArgumentException("Argument 'method' must not be null");
        }
        this.invoker = invoker;
        this.method = method;
        method.setAccessible(true);
    }

    /**
     * Execute handle method
     */
    public void execute(WxRouteMessage message) {
        Object[] args = resolveMethodArguments(message);
        try {
            method.invoke(invoker, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Never happen", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] resolveMethodArguments(WxRouteMessage message) {
        WxHandlerArguments resolver = new WxHandlerArguments(method, message);
        return resolver.resolveArguments();
    }

}