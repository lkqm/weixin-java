package com.mario6.weixin.gateway.handler;


import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.annotation.WxEvent;
import com.mario6.weixin.gateway.model.event.InvoiceAuthEventMessage;
import com.mario6.weixin.gateway.model.event.InvoiceResultEventMessage;

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
        System.out.println("电子发票授权事件");
    }

    /**
     * 统一开票接口-异步通知开票结果
     */
    @WxEvent("cloud_invoice_invoiceresult_event")
    public void invoiceResultEvent(InvoiceResultEventMessage message) {
        System.out.println("电子发票开票结果");
    }

}