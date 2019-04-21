package com.mario6.weixin.springboot.gateway.core;


import com.mario6.weixin.springboot.gateway.model.WxXmlMessage;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * 路由规则匹配器
 *
 * @author Mario Luo
 * @date 2019.01.03 13:37
 */
@Getter
public class WxRouteRule {

    private String fromUser;

    private String msgType;

    private String event;

    private String eventKey;

    private String eventKeyRegex;

    private String content;

    private String contentRegex;

    private WxRouteHandler handler;

    //---------------非规则数据-------------------//
    private WxRouter router;
    private boolean hasAdd = false;

    public WxRouteRule(WxRouter router) {
        this.router = router;
    }

    public WxRouteRule fromUser(String fromUser) {
        this.fromUser = fromUser;
        return this;
    }

    public WxRouteRule msgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public WxRouteRule event(String event) {
        this.event = event;
        return this;
    }

    public WxRouteRule eventKey(String eventKey) {
        this.eventKey = eventKey;
        return this;
    }

    public WxRouteRule eventKeyRegex(String eventKeyRegex) {
        this.eventKeyRegex = eventKeyRegex;
        return this;
    }

    public WxRouteRule content(String content) {
        this.content = content;
        return this;
    }

    public WxRouteRule contentRegex(String contentRegex) {
        this.contentRegex = contentRegex;
        return this;
    }

    public WxRouteRule handler(WxRouteHandler handler) {
        this.handler = handler;
        return this;
    }

    public void next() {
        if (!hasAdd) {
            router.addRule(this);
            hasAdd = true;
        }
    }

    /**
     * 测试是否规则匹配
     */
    public boolean test(WxXmlMessage wxMessage) {
        return
                (this.fromUser == null || this.fromUser.equals(wxMessage.getFromUserName()))
                        &&
                        (this.msgType == null || this.msgType.equalsIgnoreCase(wxMessage.getMsgType()))
                        &&
                        (this.event == null || this.event.equalsIgnoreCase(wxMessage.getEvent()))
                        &&
                        (this.eventKey == null || this.eventKey.equalsIgnoreCase(wxMessage.getEventKey()))
                        &&
                        (this.eventKeyRegex == null || Pattern
                                .matches(this.eventKeyRegex, StringUtils.trimToEmpty(wxMessage.getEventKey())))
                        &&
                        (this.content == null || this.content
                                .equals(StringUtils.trimToNull(wxMessage.getContent())))
                        &&
                        (this.contentRegex == null || Pattern
                                .matches(this.contentRegex, StringUtils.trimToEmpty(wxMessage.getContent())))
                ;
    }

}
