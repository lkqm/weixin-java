package com.mario6.weixin.gateway.model.event;

import com.mario6.weixin.gateway.model.WxBaseEvent;
import lombok.Data;

/**
 * 公众号扫码事件消息(包括订阅)
 */
@Data
public class ScanEventMessage extends WxBaseEvent {

    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    private String eventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String ticket;
}
