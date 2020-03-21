package com.github.lkqm.springboot.weixin.gateway;

import com.github.lkqm.weixin.gateway.WxConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信网关配置
 */
@ConfigurationProperties(prefix = "wx.gateway")
@Data
public class WxGatewayProperties implements Serializable {

    /**
     * 开发模式, 不会微信校验消息的准确性
     */
    private boolean dev = false;

    /**
     * 路径前缀
     */
    private String prefix = "/wx/gateway";

    /**
     * 微信配置
     */
    Map<String, WxConfig> configs = new HashMap<>();

}
