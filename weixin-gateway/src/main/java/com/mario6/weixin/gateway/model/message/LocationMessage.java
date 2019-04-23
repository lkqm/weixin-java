package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 位置信息
 */
@Data
public class LocationMessage extends WxBaseMessage {

    /**
     * 消息ID
     */
    private Long msgId;

    /**
     * 地理位置维度
     */
    private String locationX;

    /**
     * 地理位置经度
     */
    private String locationY;

    /**
     * 地图缩放倍数
     */
    private Integer scale;

    /**
     * 位置描述
     */
    private String label;
}
