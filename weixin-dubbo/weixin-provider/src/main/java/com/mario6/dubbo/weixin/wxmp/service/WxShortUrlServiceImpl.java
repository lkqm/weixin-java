package com.mario6.dubbo.weixin.wxmp.service;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Service;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxShortUrlServiceImpl implements WxShortUrlService {

    private WxMpService wxMpService;

    @Override
    public String shortUrl(String url) {
        return handle(() -> wxMpService.shortUrl(url));
    }

}
