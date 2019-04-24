package com.mario6.dubbo.weixin.common.util;


import com.github.binarywang.wxpay.exception.WxPayException;
import me.chanjar.weixin.common.error.WxErrorException;

@FunctionalInterface
public interface WxVoidHandler {

    void handle() throws WxErrorException, WxPayException;

}
