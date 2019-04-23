package com.mario6.weixin.gateway.core.handler;


import com.mario6.weixin.gateway.base.WxBaseMessage;
import com.mario6.weixin.gateway.base.event.ScanEventMessage;
import com.mario6.weixin.gateway.core.annotation.WxController;
import com.mario6.weixin.gateway.core.annotation.WxEvent;

/**
 * 公众号关注事件
 */
@WxController
public class SubscribeHandler {

    /**
     * 订阅, 包括扫码收关注
     */
    @WxEvent("subscribe")
    public void subscribe(ScanEventMessage message) {
    }

    /**
     * 取消订阅
     */
    @WxEvent("unsubscribe")
    public void unsubscribe(WxBaseMessage message) {
    }

    /**
     * 扫码已经关注的情况
     *
     * @param message
     */
    @WxEvent("SCAN")
    public void scan(ScanEventMessage message) {
    }
}