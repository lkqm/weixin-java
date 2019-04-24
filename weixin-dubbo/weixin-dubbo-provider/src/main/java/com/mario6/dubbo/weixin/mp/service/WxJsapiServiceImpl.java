package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.api.WxMpService;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxJsapiServiceImpl implements WxJsApiService {

    private WxMpService wxMpService;

    @Override
    public String getJsapiTicket() {
        return handle(() -> wxMpService.getJsapiTicket());
    }

    @Override
    public String getJsapiTicket(boolean forceRefresh) {
        return handle(() -> wxMpService.getJsapiTicket(forceRefresh));
    }

    @Override
    public WxJsapiSignature createJsapiSignature(String url) {
        return handle(() -> wxMpService.createJsapiSignature(url));
    }
}
