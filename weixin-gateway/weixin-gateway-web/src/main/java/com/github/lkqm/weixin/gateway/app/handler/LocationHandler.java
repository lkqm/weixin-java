package com.github.lkqm.weixin.gateway.app.handler;


import com.github.lkqm.weixin.gateway.base.event.LocationEventMessage;
import com.github.lkqm.weixin.gateway.core.annotation.WxController;
import com.github.lkqm.weixin.gateway.core.annotation.WxEvent;

/**
 * 地理消息上报事件
 */
@WxController
public class LocationHandler {

    @WxEvent("location")
    public void location(LocationEventMessage message) {
    }

}