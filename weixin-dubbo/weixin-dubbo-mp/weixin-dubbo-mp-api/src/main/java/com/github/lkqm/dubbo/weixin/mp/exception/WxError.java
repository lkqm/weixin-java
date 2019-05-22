package com.github.lkqm.dubbo.weixin.mp.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class WxError implements Serializable {
    private int errorCode;
    private String errorMsg;
    private String errorMsgEn;
    private String json;

}
