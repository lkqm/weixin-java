package com.mario6.dubbo.weixin.common.util;

import com.github.binarywang.wxpay.exception.WxPayException;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 微信处理工具, 用于异常转换
 */
public class WxHandlerUtils {

    public static <T> T handle(WxHandler<T> handler) {
        try {
            return handler.handle();
        } catch (WxErrorException e) {
            throw WxErrorUtils.newWxException(e);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    public static void handle(WxVoidHandler handler) {
        try {
            handler.handle();
        } catch (WxErrorException e) {
            throw WxErrorUtils.newWxException(e);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

}
