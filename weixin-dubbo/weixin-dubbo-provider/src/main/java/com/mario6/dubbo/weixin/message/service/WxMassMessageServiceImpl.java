package com.mario6.dubbo.weixin.message.service;

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
    public WxMpMassUploadResult massNewsUpload(WxMpMassNews news) {
        return handle(() -> wxMpMassMessageService.massNewsUpload(news));
    }

    @Override
    public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) {
        return handle(() -> wxMpMassMessageService.massVideoUpload(video));
    }

    @Override
    public WxMpMassSendResult massGroupMessageSend(WxMpMassTagMessage message) {
        return handle(() -> wxMpMassMessageService.massGroupMessageSend(message));
    }

    @Override
    public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) {
        return handle(() -> wxMpMassMessageService.massOpenIdsMessageSend(message));
    }

    @Override
    public WxMpMassSendResult massMessagePreview(WxMpMassPreviewMessage wxMpMassPreviewMessage) {
        return handle(() -> wxMpMassMessageService.massMessagePreview(wxMpMassPreviewMessage));
    }

    @Override
    public void delete(Long msgId, Integer articleIndex) {
        handle(() -> wxMpMassMessageService.delete(msgId, articleIndex));
    }
}
