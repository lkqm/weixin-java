package com.github.lkqm.dubbo.weixin.mp.util;


import me.chanjar.weixin.common.error.WxErrorException;

@FunctionalInterface
public interface WxMpVoidHandler {

    void handle() throws WxErrorException;

}
