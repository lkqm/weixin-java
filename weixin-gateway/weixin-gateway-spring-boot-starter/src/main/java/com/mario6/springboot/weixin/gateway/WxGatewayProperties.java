package com.mario6.springboot.weixin.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * 微信配置
 */
@ConfigurationProperties(prefix = WxGatewayProperties.PREFIX)
@Data
public class WxGatewayProperties {

    public static final String PREFIX = "wx.mp";

    /**
     * 开发模式, 不会微信校验消息的准确性
     */
    private boolean dev = false;

    /**
     * 微信回掉地址URI
     */
    private String uri = "/wx/mp/api";


    private AppConfig app = new AppConfig();

    @Data
    public static class AppConfig implements Serializable {

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

}
