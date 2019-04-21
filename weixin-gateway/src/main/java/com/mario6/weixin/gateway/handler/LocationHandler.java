package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;

/**
 * 地理消息上报事件
 */
@WxController
public class LocationHandler {

    /**
     *
     */
    @WxEvent("location")
    public void location() {
    }

}