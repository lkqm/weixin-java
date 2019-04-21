package com.mario6.weixin.springboot.gateway.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class InvoiceResultMessage extends BaseWxMessage {

    @XmlElement(name = "fpqqlsh")
    private String fpqqlsh;

    @XmlElement(name = "nsrsbh")
    private String nsrsbh;

    @XmlElement(name = "status")
    private Integer status;
}