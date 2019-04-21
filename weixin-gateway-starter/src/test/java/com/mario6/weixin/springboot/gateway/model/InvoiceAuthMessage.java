package com.mario6.weixin.springboot.gateway.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class InvoiceAuthMessage extends BaseWxMessage {

    @XmlElement(name = "SuccOrderId")
    private String succOrderId;

    @XmlElement(name = "FailOrderId")
    private String failOrderId;

    @XmlElement(name = "AuthorizeAppId")
    private String authorizeAppId;

    @XmlElement(name = "Source")
    private String source;

}