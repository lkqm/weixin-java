package com.mario6.weixin.gateway.core.handler;


import com.mario6.weixin.gateway.base.invoice.InvoiceStatusUpdateEventMessage;
import com.mario6.weixin.gateway.core.annotation.WxController;
import com.mario6.weixin.gateway.core.annotation.WxEvent;

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