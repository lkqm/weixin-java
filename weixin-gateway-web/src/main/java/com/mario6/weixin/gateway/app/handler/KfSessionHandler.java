package com.mario6.weixin.gateway.app.handler;


import com.mario6.weixin.gateway.base.WxXmlMessage;
import com.mario6.weixin.gateway.core.annotation.WxController;
import com.mario6.weixin.gateway.core.annotation.WxEvent;

/**
 * 客服消息事件处理
 */
@WxController
public class KfSessionHandler {

    @WxEvent("kf_create_session")
    public void kfCreateSession(WxXmlMessage message) {
    }


    @WxEvent("kf_close_session")
    public void kfCloseSession(WxXmlMessage message) {
    }

    @WxEvent("kf_switch_session")
    public void kfSwitchSession(WxXmlMessage message) {
    }
}