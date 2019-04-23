package com.mario6.dubbo.weixin.common.util;


import me.chanjar.weixin.common.error.WxErrorException;

@FunctionalInterface
public interface WxHandler<T> {

    T handle() throws WxErrorException;

}
