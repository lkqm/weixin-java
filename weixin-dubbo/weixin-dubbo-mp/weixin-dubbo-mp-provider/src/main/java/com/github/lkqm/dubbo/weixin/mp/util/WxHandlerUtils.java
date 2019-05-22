package com.github.lkqm.dubbo.weixin.mp.util;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 微信处理工具, 用于异常转换
 */
public class WxHandlerUtils {

    public static <T> T handle(WxMpHandler<T> handler) {
        try {
            return handler.handle();
        } catch (WxErrorException e) {
            throw WxMpExceptionUtils.newWxException(e);
        }
    }

    public static void handle(WxMpVoidHandler handler) {
        try {
            handler.handle();
        } catch (WxErrorException e) {
            throw WxMpExceptionUtils.newWxException(e);
        }
    }

}
