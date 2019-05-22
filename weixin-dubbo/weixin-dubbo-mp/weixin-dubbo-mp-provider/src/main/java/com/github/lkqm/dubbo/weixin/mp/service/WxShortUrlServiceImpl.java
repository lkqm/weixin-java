package com.github.lkqm.dubbo.weixin.mp.service;

import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class WxShortUrlServiceImpl implements WxShortUrlService {

    private WxMpService wxMpService;

    @Override
    public String shortUrl(String url) {
        return WxHandlerUtils.handle(() -> wxMpService.shortUrl(url));
    }

}
