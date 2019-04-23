package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 图片消息
 */
@Data
public class ImageMessage extends WxBaseMessage {

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 图片的媒体id
     */
    private String mediaId;

}
