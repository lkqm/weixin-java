package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

public class WxOAuth2ServiceImpl implements WxOAuth2Service {

    private WxMpService wxMpService;

    @Override
    public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state) {
        return handle(() -> wxMpService.oauth2buildAuthorizationUrl(redirectURI, scope, state));
    }

    @Override
    public WxMpOAuth2AccessToken oauth2getAccessToken(String code) {
        return handle(() -> wxMpService.oauth2getAccessToken(code));
    }

    @Override
    public WxMpOAuth2AccessToken oauth2refreshAccessToken(String refreshToken) {
        return handle(() -> wxMpService.oauth2refreshAccessToken(refreshToken));
    }

    @Override
    public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) {
        return handle(() -> wxMpService.oauth2getUserInfo(oAuth2AccessToken, lang));
    }

    @Override
    public boolean oauth2validateAccessToken(WxMpOAuth2AccessToken oAuth2AccessToken) {
        return handle(() -> wxMpService.oauth2validateAccessToken(oAuth2AccessToken));
    }
}
