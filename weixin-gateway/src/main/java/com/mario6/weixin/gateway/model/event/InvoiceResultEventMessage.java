package com.mario6.weixin.gateway.model.event;

import com.mario6.weixin.gateway.model.WxBaseEvent;
import lombok.Data;

/**
 * 发票用户授权事件消息
 */
@Data
public class InvoiceResultEventMessage extends WxBaseEvent {

    /**
     * 发票请求流水号，唯一识别发票请求的流水号
     */
    private String fpqqlsh;

    /**
     * 纳税人识别码
     */
    private String nsrsbh;

    /**
     * 开票结果：2失败 100成功
     */
    private Integer status;

}
