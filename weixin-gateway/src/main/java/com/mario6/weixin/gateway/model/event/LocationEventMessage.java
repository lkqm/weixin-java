package com.mario6.weixin.gateway.model.event;

import com.mario6.weixin.gateway.model.WxBaseEvent;
import lombok.Data;

/**
 * 上报地理位置事件消息
 */
@Data
public class LocationEventMessage extends WxBaseEvent {

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 精确度
     */
    private String precision;
}
