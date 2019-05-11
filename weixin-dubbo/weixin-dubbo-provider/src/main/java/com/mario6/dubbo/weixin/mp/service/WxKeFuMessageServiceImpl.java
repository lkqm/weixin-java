package com.mario6.dubbo.weixin.mp.service;

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
    public boolean sendKfMessage(WxMpKefuMessage message) {
        return handle(() -> wxMpKefuService.sendKefuMessage(message));
    }

    @Override
    public WxMpKfList getKfAccountInfos() {
        return handle(() -> wxMpKefuService.kfList());
    }

    @Override
    public WxMpKfOnlineList getOnlineKfAccountInfos() {
        return handle(() -> wxMpKefuService.kfOnlineList());
    }

    @Override
    public boolean addKfAccount(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountAdd(request));
    }

    @Override
    public boolean updateKfAccount(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountUpdate(request));
    }


    @Override
    public boolean kfAccountInviteWorker(WxMpKfAccountRequest request) {
        return handle(() -> wxMpKefuService.kfAccountInviteWorker(request));
    }

    @Override
    public boolean updateKfAccountAvater(String kfAccount, File imgFile) {
        return handle(() -> wxMpKefuService.kfAccountUploadHeadImg(kfAccount, imgFile));
    }

    @Override
    public boolean deleteKfAccount(String kfAccount) {
        return handle(() -> wxMpKefuService.kfAccountDel(kfAccount));
    }

    @Override
    public boolean createKfSession(String openid, String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionCreate(openid, kfAccount));
    }

    @Override
    public boolean closeKfSession(String openid, String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionClose(openid, kfAccount));
    }

    @Override
    public WxMpKfSessionGetResult getKfSessionByUser(String openid) {
        return handle(() -> wxMpKefuService.kfSessionGet(openid));
    }

    @Override
    public WxMpKfSessionList getKfSessionsByAccount(String kfAccount) {
        return handle(() -> wxMpKefuService.kfSessionList(kfAccount));
    }

    @Override
    public WxMpKfSessionWaitCaseList getWaitKfSessions() {
        return handle(() -> wxMpKefuService.kfSessionGetWaitCase());
    }

    @Override
    public WxMpKfMsgList getKfMessages(Date startTime, Date endTime, Long msgId, Integer number) {
        return handle(() -> wxMpKefuService.kfMsgList(startTime, endTime, msgId, number));
    }

    @Override
    public WxMpKfMsgList getKfMessages(Date startTime, Date endTime) {
        return handle(() -> wxMpKefuService.kfMsgList(startTime, endTime));
    }

    @Override
    public boolean sendKfTypingState(String openid, String command) {
        return handle(() -> wxMpKefuService.sendKfTypingState(openid, command));
    }
}
