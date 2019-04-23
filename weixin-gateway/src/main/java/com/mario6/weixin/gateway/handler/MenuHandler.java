package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;
import com.mario6.springboot.weixin.gateway.annotation.WxParam;

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
