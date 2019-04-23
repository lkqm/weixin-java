package com.mario6.dubbo.weixin.wxmp.service;

import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 公众号授权服务
 */
public interface WxOAuth2Service {

    /**
     * 构造oauth2授权的url连接.
     */
    String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state);

    /**
     * 用code换取oauth2的access token.
     */
    WxMpOAuth2AccessToken oauth2getAccessToken(String code);

    /**
     * 刷新oauth2的access token.
     */
    WxMpOAuth2AccessToken oauth2refreshAccessToken(String refreshToken);

    /**
     * 用oauth2获取用户信息, 当前面引导授权时的scope是snsapi_userinfo的时候才可以.
     */
    WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang);

    /**
     * 验证oauth2的access token是否有效.
     */
    boolean oauth2validateAccessToken(WxMpOAuth2AccessToken oAuth2AccessToken);

}
