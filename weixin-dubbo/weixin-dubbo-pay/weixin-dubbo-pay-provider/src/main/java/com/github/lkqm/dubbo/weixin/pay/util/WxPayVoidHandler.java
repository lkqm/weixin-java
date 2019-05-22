package com.github.lkqm.dubbo.weixin.pay.util;


import com.github.binarywang.wxpay.exception.WxPayException;

@FunctionalInterface
public interface WxPayVoidHandler {

    void handle() throws WxPayException;

}
