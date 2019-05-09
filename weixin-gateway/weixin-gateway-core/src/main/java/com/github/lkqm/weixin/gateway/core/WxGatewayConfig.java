package com.github.lkqm.weixin.gateway.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * 微信配置
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class WxGatewayConfig implements Serializable {

    /**
     * 调试模式下: 不会进行消息准确性校验
     */
    private boolean dev = false;

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
