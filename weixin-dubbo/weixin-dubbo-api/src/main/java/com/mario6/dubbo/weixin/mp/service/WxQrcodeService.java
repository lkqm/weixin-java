package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

/**
 * 微信账户管理-二维码管理
 */
public interface WxQrcodeService {

    /**
     * 创建临时二维码
     */
    WxMpQrCodeTicket createTempQrcode(String sceneStr, Integer expireSeconds);

    /**
     * 创建永久二维码
     */
    WxMpQrCodeTicket createPermQrcode(String sceneStr);

    /**
     * 获取二维码图片地址
     */
    String getQrcodePictureUrl(String ticket);
}
