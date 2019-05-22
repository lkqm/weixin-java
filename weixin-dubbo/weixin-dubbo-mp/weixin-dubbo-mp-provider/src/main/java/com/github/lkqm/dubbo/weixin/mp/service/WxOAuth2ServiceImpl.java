package com.github.lkqm.dubbo.weixin.mp.service;

import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;


public class WxOAuth2ServiceImpl implements WxOAuth2Service {

    private WxMpService wxMpService;

    @Override
    public String buildOauth2AuthorizationUrl(String redirectURI, String scope, String state) {
        return WxHandlerUtils.handle(() -> wxMpService.oauth2buildAuthorizationUrl(redirectURI, scope, state));
    }

    @Override
    public WxMpOAuth2AccessToken getOauth2AccessToken(String code) {
        return WxHandlerUtils.handle(() -> wxMpService.oauth2getAccessToken(code));
    }

    @Override
    public WxMpOAuth2AccessToken refreshOauth2AccessToken(String refreshToken) {
        return WxHandlerUtils.handle(() -> wxMpService.oauth2refreshAccessToken(refreshToken));
    }

    @Override
    public WxMpUser getOauth2UserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang) {
        return WxHandlerUtils.handle(() -> wxMpService.oauth2getUserInfo(oAuth2AccessToken, lang));
    }

    @Override
    public boolean validateOauth2AccessToken(WxMpOAuth2AccessToken oAuth2AccessToken) {
        return WxHandlerUtils.handle(() -> wxMpService.oauth2validateAccessToken(oAuth2AccessToken));
    }
}
