package com.github.lkqm.weixin.gateway.core.util;

import com.alibaba.fastjson.JSONObject;
import com.github.lkqm.weixin.gateway.core.WxRouteMessage;

import java.util.Map;

public abstract class WxMessageUtils {

    public static WxRouteMessage createFromXml(String xml) {
        Map<String, Object> orgMapData = XmlConverter.convertToOrgMap(xml);
        Map<String, Object> camelMapData = XmlConverter.convertToCamelMap(xml);
        String json = JSONObject.toJSONString(camelMapData);

        WxRouteMessage message = JSONObject.parseObject(json, WxRouteMessage.class);
        message.setXml(xml);
        message.setCamelJson(json);
        message.setXmlMap(orgMapData);
        message.setXmlCamelMap(camelMapData);
        return message;
    }
}
