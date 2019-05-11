package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpMassMessageService;
import me.chanjar.weixin.mp.bean.*;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxMassMessageServiceImpl implements WxMassMessageService {

    private WxMpMassMessageService wxMpMassMessageService;

    @Override
    public WxMpMassUploadResult uploadMassNews(WxMpMassNews news) {
        return handle(() -> wxMpMassMessageService.massNewsUpload(news));
    }

    @Override
    public WxMpMassUploadResult uploadMmassVideo(WxMpMassVideo video) {
        return handle(() -> wxMpMassMessageService.massVideoUpload(video));
    }

    @Override
    public WxMpMassSendResult sendMassMessageByTag(WxMpMassTagMessage message) {
        return handle(() -> wxMpMassMessageService.massGroupMessageSend(message));
    }

    @Override
    public WxMpMassSendResult sendMassMessageByOpenIds(WxMpMassOpenIdsMessage message) {
        return handle(() -> wxMpMassMessageService.massOpenIdsMessageSend(message));
    }

    @Override
    public WxMpMassSendResult previewMassMessage(WxMpMassPreviewMessage wxMpMassPreviewMessage) {
        return handle(() -> wxMpMassMessageService.massMessagePreview(wxMpMassPreviewMessage));
    }

    @Override
    public void deleteMassMessage(Long msgId, Integer articleIndex) {
        handle(() -> wxMpMassMessageService.delete(msgId, articleIndex));
    }
}
