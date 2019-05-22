package com.github.lkqm.dubbo.weixin.pay.util;

import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * 微信处理工具, 用于异常转换
 */
public class WxHandlerUtils {

    public static <T> T handle(WxPayHandler<T> handler) {
        try {
            return handler.handle();
        } catch (WxPayException e) {
            throw WxPayExceptionUtils.newWxPayException(e);
        }
    }

    public static void handle(WxPayVoidHandler handler) {
        try {
            handler.handle();
        } catch (WxPayException e) {
            throw WxPayExceptionUtils.newWxPayException(e);
        }
    }

}
