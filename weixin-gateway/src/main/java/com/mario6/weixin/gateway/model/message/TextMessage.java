package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 文本消息
 */
@Data
public class TextMessage extends WxBaseMessage {

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 内容
     */
    private String content;
}
