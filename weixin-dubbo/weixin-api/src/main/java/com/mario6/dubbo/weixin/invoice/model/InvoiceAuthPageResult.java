package com.mario6.dubbo.weixin.invoice.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取授权链接返回结果DTO
 */
@Data
public class InvoiceAuthPageResult implements Serializable {

    /**
     * 授权页地址
     */
    private String authUrl;

    /**
     * 当发起端为小程序时, 返回
     */
    private String appid;
}
