package com.mario6.weixin.gateway.starter;

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
