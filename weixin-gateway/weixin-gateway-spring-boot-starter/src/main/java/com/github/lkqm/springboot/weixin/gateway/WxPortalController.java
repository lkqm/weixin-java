package com.github.lkqm.springboot.weixin.gateway;

import com.github.lkqm.weixin.gateway.core.WxPortalHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 微信回掉入口控制器
 */
@Slf4j
@AllArgsConstructor
public class WxPortalController {

    private WxPortalHandler handler;

    /**
     * 服务器认证方法
     */
    @GetMapping(produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String get(String signature, String timestamp, String nonce, String echostr) {
        return handler.get(signature, timestamp, nonce, echostr);
    }

    /**
     * 消息处理方法
     */
    @PostMapping(produces = "application/xml; charset=UTF-8")
    @ResponseBody
    public String post(@RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        return handler.post(requestBody, signature, timestamp, nonce, openid, encType, msgSignature);
    }

}