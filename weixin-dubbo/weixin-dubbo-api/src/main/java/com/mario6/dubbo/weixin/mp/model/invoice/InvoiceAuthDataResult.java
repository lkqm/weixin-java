package com.mario6.dubbo.weixin.mp.model.invoice;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户开票认证信息返回结果DTO
 */
@Data
public class InvoiceAuthDataResult implements Serializable {

    /**
     * 订单授权状态，当errcode为0时会出现
     */
    private String invoiceStatus;

    /**
     * 授权时间，为十位时间戳（utc+8），当errcode为0时会出现
     */
    private Long authTime;

    /**
     * 用户授权信息
     */
    private Object userAuthInfo;
}
