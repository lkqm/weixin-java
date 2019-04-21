package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;

/**
 * 菜单相关事件
 *
 * @author Mario Luo
 * @date 2019.01.04 21:21
 */
@WxController
public class MenuHandler {

    /**
     * 菜单点击
     */
    @WxEvent("click")
    public void click() {
    }

    /**
     * 菜单点击
     */
    @WxEvent("view")
    public void view() {
    }
}
