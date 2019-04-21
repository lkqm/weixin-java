package com.mario6.weixin.springboot.gateway;

import com.mario6.weixin.springboot.gateway.annotation.WxBody;
import com.mario6.weixin.springboot.gateway.annotation.WxController;
import com.mario6.weixin.springboot.gateway.annotation.WxEvent;
import com.mario6.weixin.springboot.gateway.annotation.WxParam;
import com.mario6.weixin.springboot.gateway.model.InvoiceAuthMessage;
import com.mario6.weixin.springboot.gateway.model.InvoiceResultMessage;
import com.mario6.weixin.springboot.gateway.model.WxXmlMessage;

import java.util.Map;

/**
 * 微信相关控制器
 */
@WxController
public class InvoiceHandler {

    @WxEvent("user_authorize_invoice")
    public void authEvent(WxXmlMessage message, InvoiceAuthMessage authMessage,
                          @WxBody String xml, @WxParam("FromUserName") String fromUser,
                          @WxParam("CreateTime") Integer createTime,
                          Map<String, String> map,
                          int intValue, short shortValue, char charValue, long longValue,
                          float floatValue, double doubleValue) {
        System.out.println("@XmlRootElement: " + authMessage);
        System.out.println("@WxBody: " + xml);
        System.out.println("Map: " + map);
        System.out.println("@WxParam('FromUserName'): " + fromUser);
        System.out.println("@WxParam('CreateTime'): " + createTime);
    }

    @WxEvent("cloud_invoice_invoiceresult_event")
    public void invoiceResultEvent(InvoiceResultMessage message, Map<String, String> xml) {

    }

}