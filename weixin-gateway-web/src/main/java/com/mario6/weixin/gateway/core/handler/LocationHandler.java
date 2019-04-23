package com.mario6.weixin.gateway.core.handler;


import com.mario6.weixin.gateway.base.event.LocationEventMessage;
import com.mario6.weixin.gateway.core.annotation.WxController;
import com.mario6.weixin.gateway.core.annotation.WxEvent;

/**
 * 地理消息上报事件
 */
@WxController
public class LocationHandler {

    @WxEvent("location")
    public void location(LocationEventMessage message) {
    }

}