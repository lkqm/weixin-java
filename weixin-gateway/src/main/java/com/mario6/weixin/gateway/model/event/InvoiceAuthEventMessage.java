package com.mario6.weixin.gateway.model.event;

import com.mario6.weixin.gateway.model.WxBaseEvent;

/**
 * 发票用户授权事件消息
 */
public class InvoiceAuthEventMessage extends WxBaseEvent {
    /**
     * 授权成功的订单号，与失败订单号两者必显示其一
     */
    private String succOrderId;

    /**
     * 授权失败的订单号，与成功订单号两者必显示其一
     */
    private String failOrderId;

    /**
     * 获取授权页链接的AppId
     */
    private String authorizeAppId;

    /**
     * 授权来源，web：公众号开票，app：app开票，wxa：小程序开票，wap：h5开票
     */
    private String source;

}
