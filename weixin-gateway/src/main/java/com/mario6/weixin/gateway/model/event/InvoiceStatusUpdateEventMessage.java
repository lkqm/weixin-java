package com.mario6.weixin.gateway.model.event;

import com.mario6.weixin.gateway.model.WxBaseEvent;

/**
 * 发票状态变化事件
 */
public class InvoiceStatusUpdateEventMessage extends WxBaseEvent {

    /**
     * 发票code
     */
    private String code;

    /**
     * 发票id
     */
    private String cardId;

    /**
     * 发票报销状态
     */
    private String status;

}
