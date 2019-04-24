package com.mario6.weixin.gateway.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 路由消息处理内部使用, 事实不可变对象
 */
@Data
public class WxRouteMessage implements Serializable {


    /**
     * 开发者账号
     */
    private String toUserName;

    /**
     * 发送方账号
     */
    private String fromUserName;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 事件类型
     */
    private String event;

    //------------------原始信息------------------------//

    /**
     * 原始xml数据
     */
    private transient String xml;

    /**
     * 由xml按照特定规则数据转为的json
     */
    private transient String camelJson;

    /**
     * 原始xml数据map
     */
    private transient Map<String, Object> xmlMap;

    /**
     * 原始xml数据map
     */
    private transient Map<String, Object> xmlCamelMap;
}
