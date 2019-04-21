package com.mario6.springboot.weixin.gateway.core;

import com.mario6.springboot.weixin.gateway.model.WxXmlMessage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 路由处理者
 *
 * @author Mario Luo
 * @date 2019.01.03 09:38
 */
public class WxRouteHandler {

    private Object invoker;
    private Method method;

    private WxRouteHandler(Object invoker, Method method) {
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

    public static WxRouteHandler create(Object invoker, Method method) {
        return new WxRouteHandler(invoker, method);
    }

    public void handle(WxXmlMessage message) {
        Object[] args = resolveMethodArguments(message);
        try {
            method.invoke(invoker, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] resolveMethodArguments(WxXmlMessage message) {
        WxRouteHandlerArgumentsResolver resolver = new WxRouteHandlerArgumentsResolver(method, message);
        return resolver.resolveArguments();
    }

}