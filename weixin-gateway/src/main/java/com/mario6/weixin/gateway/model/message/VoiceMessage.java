package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 语音消息
 */
@Data
public class VoiceMessage extends WxBaseMessage {

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 语音媒体id
     */
    private String mediaId;

    /**
     * 语音格式
     */
    private String format;

    /**
     * 识别文字
     */
    private String recognition;

}
