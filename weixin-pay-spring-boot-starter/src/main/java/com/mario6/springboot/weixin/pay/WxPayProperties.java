package com.mario6.springboot.weixin.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.mario6.springboot.weixin.pay.WxPayProperties.PREFIX;


/**
 * 微信支付相关配置属性
 */
@Data
@ConfigurationProperties(PREFIX)
public class WxPayProperties {
    public static final String PREFIX = "wx.pay";

    /**
     * 是否使用沙箱环境
     */
    private boolean enableSandboxEnv = false;

    /**
     * 设置微信公众号或者小程序等的appid
     */
    private String appId;

    /**
     * 微信支付商户号
     */
    private String mchId;

    /**
     * 微信支付商户密钥
     */
    private String mchKey;

    /**
     * 服务商模式下的子商户公众账号ID，普通模式请不要配置，请在配置文件中将对应项删除
     */
    private String subAppId;

    /**
     * 服务商模式下的子商户号，普通模式请不要配置，最好是请在配置文件中将对应项删除
     */
    private String subMchId;

    /**
     * apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定
     */
    private String keyPath;

}
