package com.mario6.weixin.gateway.core;


import com.mario6.weixin.gateway.base.WxRouteMessage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 路由处理者
 */
public class WxHandler {

    private Object invoker;
    private Method method;

    public static WxHandler create(Object invoker, Method method) {
        return new WxHandler(invoker, method);
    }

    private WxHandler(Object invoker, Method method) {
        if (invoker == null) {
            throw new IllegalArgumentException("Argument 'invoker' can't be null");
        }
        if (method == null) {
            throw new IllegalArgumentException("Argument 'method' can't be null");
        }
        this.invoker = invoker;
        this.method = method;
        method.setAccessible(true);
    }

    public void handle(WxRouteMessage message) {
        Object[] args = resolveMethodArguments(message);
        try {
            method.invoke(invoker, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] resolveMethodArguments(WxRouteMessage message) {
        WxHandlerArguments resolver = new WxHandlerArguments(method, message);
        return resolver.resolveArguments();
    }

}