package com.mario6.weixin.springboot.gateway.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * 微信消息基本数据
 */
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class BaseWxMessage implements Serializable {

    @XmlElement(name = "ToUserName")
    protected String toUserName;

    @XmlElement(name = "FromUserName")
    protected String fromUserName;

    @XmlElement(name = "CreateTime")
    protected Long createTime;

    @XmlElement(name = "MsgType")
    protected String msgType;

    @XmlElement(name = "Content")
    protected String content;

    @XmlElement(name = "Event")
    protected String event;
}
