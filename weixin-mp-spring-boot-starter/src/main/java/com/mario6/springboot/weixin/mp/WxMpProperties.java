package com.mario6.springboot.weixin.mp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

import static com.mario6.springboot.weixin.mp.WxMpProperties.PREFIX;
import static com.mario6.springboot.weixin.mp.WxMpProperties.StorageType.memory;


/**
 * 微信接入相关配置属性
 */
@Data
@ConfigurationProperties(PREFIX)
public class WxMpProperties {
    public static final String PREFIX = "wx.mp";

    /**
     * 应用配置
     */
    private App app = new App();

    /**
     * 存储策略, memory, redis
     */
    private Storage storage = new Storage();

    @Data
    public static class App implements Serializable {
        /**
         * 设置微信公众号的appid
         */
        private String appId;

        /**
         * 设置微信公众号的app secret
         */
        private String secret;

        /**
         * 设置微信公众号的token
         */
        private String token;

        /**
         * 设置微信公众号的EncodingAESKey
         */
        private String aesKey;
    }

    @Data
    public static class Storage implements Serializable {

        private StorageType type = memory;

        private RedisProperties redis = new RedisProperties();

    }

    /**
     * 存储策略
     */
    public static enum StorageType {
        memory, redis
    }
}
