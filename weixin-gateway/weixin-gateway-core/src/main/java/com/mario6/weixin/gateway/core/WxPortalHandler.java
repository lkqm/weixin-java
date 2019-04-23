package com.mario6.weixin.gateway.core;

import com.mario6.weixin.gateway.core.util.WxUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 微信回掉入口控制器
 */
@Slf4j
@AllArgsConstructor
public class WxPortalHandler {

    private WxMpConfig config;

    private WxRouter router;

    /**
     * 服务器认证方法
     */
    public String get(String signature, String timestamp, String nonce, String echostr) {
        log.info("接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            return "非法请求";
        }
        String token = config.getToken();
        if (WxUtils.checkSignature(token, timestamp, nonce, signature)) {
            return echostr;
        }
        return "非法请求";
    }

    /**
     * 消息处理方法
     */
    public String post(String requestBody, String signature, String timestamp, String nonce, String openid, String encType, String msgSignature) {
        log.info("接收微信请求：[openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                openid, signature, encType, msgSignature, timestamp, nonce, requestBody);

        String token = config.getToken();
        if (!WxUtils.checkSignature(token, timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }

        String xml = requestBody;
        if ("AES".equalsIgnoreCase(encType)) {
            xml = WxUtils.decryptXml(config, requestBody);
        }
        router.route(xml);
        return "";
    }

}