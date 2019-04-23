package com.mario6.weixin.gateway.core;


import com.mario6.weixin.gateway.base.WxXmlMessage;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 路由规则匹配器
 */
@Getter
public class WxRouteRule {

    private String msgType;

    private String event;

    private WxHandler handler;

    //---------------非规则数据-------------------//
    private WxRouter router;
    private boolean hasAdd = false;

    public WxRouteRule(WxRouter router) {
        this.router = router;
    }

    public WxRouteRule msgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public WxRouteRule event(String event) {
        this.event = event;
        return this;
    }

    public WxRouteRule handler(WxHandler handler) {
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
        String wxMsgType = wxMessage.getMsgType();
        String wxEvent = wxMessage.getEvent();

        if (!StringUtils.equalsIgnoreCase(wxMsgType, msgType)) {
            return false;
        }


        if (StringUtils.equalsIgnoreCase(wxMsgType, "event")
                && !StringUtils.equalsIgnoreCase(wxEvent, event)) {
            return false;
        }

        return true;
    }

}
