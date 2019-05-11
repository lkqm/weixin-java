package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 公众号授权服务
 *
 * 文档: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 */
public interface WxOAuth2Service {

    /**
     * 构造oauth2授权的url连接.
     */
    String buildOauth2AuthorizationUrl(String redirectURI, String scope, String state);

    /**
     * 用code换取oauth2的access token.
     */
    WxMpOAuth2AccessToken getOauth2AccessToken(String code);

    /**
     * 刷新oauth2的access token.
     */
    WxMpOAuth2AccessToken refreshOauth2AccessToken(String refreshToken);

    /**
     * 用oauth2获取用户信息, 当前面引导授权时的scope是snsapi_userinfo的时候才可以.
     */
    WxMpUser getOauth2UserInfo(WxMpOAuth2AccessToken oAuth2AccessToken, String lang);

    /**
     * 验证oauth2的access token是否有效.
     */
    boolean validateOauth2AccessToken(WxMpOAuth2AccessToken oAuth2AccessToken);

}
