package com.github.lkqm.weixin.gateway.base.message;

import com.github.lkqm.weixin.gateway.base.WxBaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 图片消息
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
