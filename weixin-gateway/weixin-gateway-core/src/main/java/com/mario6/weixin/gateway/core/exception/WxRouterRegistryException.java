package com.mario6.weixin.gateway.core.exception;

/**
 * 微信路由注册异常
 */
public class WxRouterRegistryException extends RuntimeException {

    public WxRouterRegistryException() {
    }

    public WxRouterRegistryException(String message) {
        super(message);
    }

    public WxRouterRegistryException(String message, Throwable cause) {
        super(message, cause);
    }

    public WxRouterRegistryException(Throwable cause) {
        super(cause);
    }

    public WxRouterRegistryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
