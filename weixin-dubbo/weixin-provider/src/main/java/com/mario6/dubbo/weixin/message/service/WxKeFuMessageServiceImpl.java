package com.mario6.dubbo.weixin.message.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpKefuService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.kefu.request.WxMpKfAccountRequest;
import me.chanjar.weixin.mp.bean.kefu.result.*;

import java.io.File;
import java.util.Date;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxKeFuMessageServiceImpl implements WxKeFuMessageService {
    private WxMpKefuService wxMpKefuService;


    @Override
    public boolean sendKefuMessage(WxMpKefuMessage message) {
        return handle(() -> wxMpKefuService.sendKefuMessage(message));
    }

    @Override
    public WxMpKfList kfList() {
        return handle(() -> wxMpKefuService.kfList());
    }

    @Override
    public WxMpKfOnlineList kfOnlineList() {
        return handle(() -> wxMpKefuService.kfOnlineList());
    }

    @Override
    public boolean kfAccountAdd(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountAdd(request));
    }

    @Override
    public boolean kfAccountUpdate(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountUpdate(request));
    }


    @Override
    public boolean kfAccountInviteWorker(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountInviteWorker(request));
    }

    @Override
    public boolean kfAccountUploadHeadImg(String kfAccount, File imgFile) {
        return handle(() -> wxMpKefuService.kfAccountUploadHeadImg(kfAccount, imgFile));
    }

    @Override
    public boolean kfAccountDel(String kfAccount) {
        return handle(() -> wxMpKefuService.kfAccountDel(kfAccount));
    }

    @Override
    public boolean kfSessionCreate(String openid, String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionCreate(openid, kfAccount));
    }

    @Override
    public boolean kfSessionClose(String openid, String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionClose(openid, kfAccount));
    }

    @Override
    public WxMpKfSessionGetResult kfSessionGet(String openid) {
        return handle(() -> wxMpKefuService.kfSessionGet(openid));
    }

    @Override
    public WxMpKfSessionList kfSessionList(String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionList(kfAccount));
    }

    @Override
    public WxMpKfSessionWaitCaseList kfSessionGetWaitCase() {
        return handle(() -> wxMpKefuService.kfSessionGetWaitCase());
    }

    @Override
    public WxMpKfMsgList kfMsgList(Date startTime, Date endTime, Long msgId, Integer number) {
        return handle(() -> wxMpKefuService.kfMsgList(startTime, endTime, msgId, number));
    }

    @Override
    public WxMpKfMsgList kfMsgList(Date startTime, Date endTime) {
        return handle(() -> wxMpKefuService.kfMsgList(startTime, endTime));
    }

    @Override
    public boolean sendKfTypingState(String openid, String command) {
        return handle(() -> wxMpKefuService.sendKfTypingState(openid, command));
    }
}
