package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxQrcodeServiceImpl implements WxQrcodeService {

    private WxMpQrcodeService wxMpQrcodeService;


    @Override
    public WxMpQrCodeTicket createTempQrcode(String sceneStr, Integer expireSeconds) {
        return handle(() -> wxMpQrcodeService.qrCodeCreateTmpTicket(sceneStr, expireSeconds));
    }

    @Override
    public WxMpQrCodeTicket createPermQrcode(String sceneStr) {
        return handle(() -> wxMpQrcodeService.qrCodeCreateLastTicket(sceneStr));
    }

    @Override
    public String getQrcodePictureUrl(String ticket) {
        return handle(() -> wxMpQrcodeService.qrCodePictureUrl(ticket));
    }
}
