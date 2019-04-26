package com.mario6.springboot.weixin.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信配置
 */
@ConfigurationProperties(prefix = "wx.gateway")
@Data
public class WxGatewayProperties {

    /**
     * 开发模式, 不会微信校验消息的准确性
     */
    private boolean dev = false;

    /**
     * 公众号回掉地址uri
     */
    private String uri = "/wx/mp/api";

    /**
     * 微信公众号appId
     */
    private String appId;

    /**
     * 微信公众号token
     */
    private String token;

    /**
     * 微信公众号aesKey
     */
    private String aesKey;

}
