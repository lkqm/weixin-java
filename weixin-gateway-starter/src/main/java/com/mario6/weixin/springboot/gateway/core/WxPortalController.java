package com.mario6.weixin.springboot.gateway.core;

import com.mario6.weixin.springboot.gateway.WxGatewayProperties;
import com.mario6.weixin.springboot.gateway.util.WxUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信回掉入口控制器
 */
@Slf4j
public class WxPortalController {

    @Autowired
    private WxGatewayProperties properties;

    @Autowired
    private WxRouter router;

    @GetMapping(produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String get(String signature, String timestamp, String nonce, String echostr) {
        log.info("接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            return "非法请求";
        }
        String token = properties.getApp().getToken();
        if (WxUtils.checkSignature(token, timestamp, nonce, signature)) {
            return echostr;
        }
        return "非法请求";
    }

    @PostMapping(produces = "application/xml; charset=UTF-8")
    @ResponseBody
    public String post(@RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("接收微信请求：[openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                openid, signature, encType, msgSignature, timestamp, nonce, requestBody);

        final String token = properties.getApp().getToken();
        if (!WxUtils.checkSignature(token, timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }

        String xml = requestBody;
        if ("AES".equalsIgnoreCase(encType)) {
            xml = WxUtils.decryptXml(properties.getApp(), requestBody);
        }
        router.route(xml);
        return "";
    }

}