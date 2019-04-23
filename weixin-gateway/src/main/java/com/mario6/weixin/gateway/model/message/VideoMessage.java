package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 视频消息
 */
@Data
public class VideoMessage extends WxBaseMessage {

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 语音媒体id
     */
    private String mediaId;

    /**
     * 缩略图媒体id
     */
    private String thumbMediaId;

}
