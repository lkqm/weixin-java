package com.github.lkqm.dubbo.weixin.pay.util;


import com.github.binarywang.wxpay.exception.WxPayException;

@FunctionalInterface
public interface WxPayHandler<T> {

    T handle() throws WxPayException;

}
