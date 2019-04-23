package com.mario6.dubbo.weixin.message.service;

import me.chanjar.weixin.mp.bean.*;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;

/**
 * 群发消息
 */
public interface WxMassMessageService {

    /**
     * 上传群发用的图文消息，上传后才能群发图文消息
     */
    WxMpMassUploadResult massNewsUpload(WxMpMassNews news);

    /**
     * 上传群发用的视频，上传后才能群发视频消息
     */
    WxMpMassUploadResult massVideoUpload(WxMpMassVideo video);

    /**
     * 分组群发消息
     */
    WxMpMassSendResult massGroupMessageSend(WxMpMassTagMessage message);

    /**
     * 按openId列表群发消息
     */
    WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message);

    /**
     * 群发消息预览接口
     */
    WxMpMassSendResult massMessagePreview(WxMpMassPreviewMessage wxMpMassPreviewMessage);

    /**
     * 群发之后，随时可以通过该接口删除群发
     */
    void delete(Long msgId, Integer articleIndex);

}
