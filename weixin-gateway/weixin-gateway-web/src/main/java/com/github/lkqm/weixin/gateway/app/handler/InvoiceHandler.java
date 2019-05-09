package com.github.lkqm.weixin.gateway.app.handler;


import com.github.lkqm.weixin.gateway.base.invoice.InvoiceAuthEventMessage;
import com.github.lkqm.weixin.gateway.base.invoice.InvoiceResultEventMessage;
import com.github.lkqm.weixin.gateway.core.annotation.WxController;
import com.github.lkqm.weixin.gateway.core.annotation.WxEvent;

/**
 * 商户电子发票相关事件
 */
@WxController
public class InvoiceHandler {

    /**
     * 收取授权完成事件
     */
    @WxEvent("user_authorize_invoice")
    public void authorEvent(InvoiceAuthEventMessage message) {
    }

    /**
     * 统一开票接口-异步通知开票结果
     */
    @WxEvent("cloud_invoice_invoiceresult_event")
    public void invoiceResultEvent(InvoiceResultEventMessage message) {
    }

}