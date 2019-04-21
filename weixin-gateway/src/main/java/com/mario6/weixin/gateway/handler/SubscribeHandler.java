package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;

/**
 * 公众号关注事件
 */
@WxController
public class SubscribeHandler {

    /**
     * 订阅
     */
    @WxEvent("subscribe")
    public void subscribe() {
    }

    /**
     * 取消订阅
     */
    @WxEvent("unsubscribe")
    public void unsubscribe() {
    }

}