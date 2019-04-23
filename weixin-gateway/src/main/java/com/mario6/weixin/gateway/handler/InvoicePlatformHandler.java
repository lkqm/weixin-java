package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;
import com.mario6.weixin.gateway.model.event.InvoiceStatusUpdateEventMessage;

/**
 * 开票平台相关事件
 */
@WxController
public class InvoicePlatformHandler {

    /**
     * 电子发票状态
     */
    @WxEvent("update_invoice_status")
    public void updateInvoiceStatusEvent(InvoiceStatusUpdateEventMessage message) {
    }

}