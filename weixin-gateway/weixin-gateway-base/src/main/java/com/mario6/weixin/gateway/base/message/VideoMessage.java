package com.mario6.weixin.gateway.base.message;

import com.mario6.weixin.gateway.base.WxBaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 视频消息
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
