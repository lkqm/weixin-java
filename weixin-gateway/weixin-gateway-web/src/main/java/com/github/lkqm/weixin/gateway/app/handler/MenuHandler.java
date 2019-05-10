package com.github.lkqm.weixin.gateway.app.handler;


import com.github.lkqm.weixin.gateway.core.annotation.WxController;
import com.github.lkqm.weixin.gateway.core.annotation.WxEvent;
import com.github.lkqm.weixin.gateway.core.annotation.WxParam;

/**
 * 菜单相关事件
 */
@WxController
public class MenuHandler {

    @WxEvent("click")
    public void click(@WxParam("EventKey") String eventKey) {
    }

    @WxEvent("view")
    public void view(@WxParam("EventKey") String eventKey) {
    }
}