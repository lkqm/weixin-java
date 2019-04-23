package com.mario6.weixin.gateway.model.message;

import com.mario6.weixin.gateway.model.WxBaseMessage;
import lombok.Data;

/**
 * 文本消息
 */
@Data
public class LinkMessage extends WxBaseMessage {

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 链接地址
     */
    private String url;
}
