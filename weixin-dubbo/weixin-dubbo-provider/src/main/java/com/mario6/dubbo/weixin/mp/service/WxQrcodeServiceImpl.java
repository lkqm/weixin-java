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
    public WxMpQrCodeTicket createTempQrcode(String data, Integer expireSeconds) {
        return handle(() -> wxMpQrcodeService.qrCodeCreateTmpTicket(data, expireSeconds));
    }

    @Override
    public WxMpQrCodeTicket createPermQrcode(String data) {
        return handle(() -> wxMpQrcodeService.qrCodeCreateLastTicket(data));
    }

    @Override
    public String getQrcodePictureUrl(String ticket) {
        return handle(() -> wxMpQrcodeService.qrCodePictureUrl(ticket));
    }
}
