package com.github.lkqm.weixin.gateway.app.handler;


import com.github.lkqm.weixin.gateway.base.WxBaseEvent;
import com.github.lkqm.weixin.gateway.core.annotation.WxController;
import com.github.lkqm.weixin.gateway.core.annotation.WxEvent;

/**
 * 客服消息事件处理
 */
@WxController
public class KfSessionHandler {

    @WxEvent("kf_create_session")
    public void kfCreateSession(WxBaseEvent message) {
    }


    @WxEvent("kf_close_session")
    public void kfCloseSession(WxBaseEvent message) {
    }

    @WxEvent("kf_switch_session")
    public void kfSwitchSession(WxBaseEvent message) {
    }
}