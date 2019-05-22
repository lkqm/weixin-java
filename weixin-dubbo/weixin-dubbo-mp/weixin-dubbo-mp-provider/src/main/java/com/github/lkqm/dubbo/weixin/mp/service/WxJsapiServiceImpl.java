package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.api.WxMpService;

@Service
@AllArgsConstructor
public class WxJsapiServiceImpl implements WxJsApiService {

    private WxMpService wxMpService;

    @Override
    public String getJsapiTicket() {
        return WxHandlerUtils.handle(() -> wxMpService.getJsapiTicket());
    }

    @Override
    public String getJsapiTicket(boolean forceRefresh) {
        return WxHandlerUtils.handle(() -> wxMpService.getJsapiTicket(forceRefresh));
    }

    @Override
    public WxJsapiSignature createJsapiSignature(String url) {
        return WxHandlerUtils.handle(() -> wxMpService.createJsapiSignature(url));
    }
}
