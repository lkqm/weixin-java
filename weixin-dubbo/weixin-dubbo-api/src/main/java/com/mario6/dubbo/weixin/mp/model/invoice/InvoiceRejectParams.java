package com.mario6.dubbo.weixin.mp.model.invoice;

import java.io.Serializable;

/**
 * 拒绝开票参数DTO
 */
public class InvoiceRejectParams implements Serializable {

    /**
     * 开票平台标示
     */
    private String sPappid;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 拒绝原因
     */
    private String reason;

    /**
     * 引导用户跳转url
     */
    private String url;

}
