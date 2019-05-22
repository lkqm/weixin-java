package com.github.lkqm.dubbo.weixin.mp.util;


import me.chanjar.weixin.common.error.WxErrorException;

@FunctionalInterface
public interface WxMpHandler<T> {

    T handle() throws WxErrorException;

}
