package com.mario6.dubbo.weixin.message.service;

import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.kefu.request.WxMpKfAccountRequest;
import me.chanjar.weixin.mp.bean.kefu.result.*;

import java.io.File;
import java.util.Date;

public interface WxKeFuMessageService {

    /**
     * 发送客服消息
     */
    boolean sendKefuMessage(WxMpKefuMessage message);

    /**
     * 获取客服列表
     */
    WxMpKfList kfList();

    /**
     * 获取在线客服列表
     */
    WxMpKfOnlineList kfOnlineList();

    /**
     * 添加客服
     */
    boolean kfAccountAdd(WxMpKfAccountRequest request);

    /**
     * 更新客服
     */
    boolean kfAccountUpdate(WxMpKfAccountRequest request);


    boolean kfAccountInviteWorker(WxMpKfAccountRequest request);

    boolean kfAccountUploadHeadImg(String kfAccount, File imgFile);

    /**
     * 删除客服账号
     */
    boolean kfAccountDel(String kfAccount);

    /**
     * 创建用户和客服会话
     */
    boolean kfSessionCreate(String openid, String kfAccount);

    /**
     * 关闭用户和客服会话
     */
    boolean kfSessionClose(String openid, String kfAccount);

    /**
     * 获取指定用户的客服会话信息
     */
    WxMpKfSessionGetResult kfSessionGet(String openid);

    /**
     * 获取指定客服的会话列表
     */
    WxMpKfSessionList kfSessionList(String kfAccount);

    /**
     * 获取当前等待的客服会话
     */
    WxMpKfSessionWaitCaseList kfSessionGetWaitCase();

    /**
     * 获取会话消息列表
     *
     * @param startTime
     * @param endTime
     * @param msgId
     * @param number
     * @return
     */
    WxMpKfMsgList kfMsgList(Date startTime, Date endTime, Long msgId, Integer number);

    /**
     * 获取会话消息
     */
    WxMpKfMsgList kfMsgList(Date startTime, Date endTime);

    /**
     * 发送客服输入状态
     */
    boolean sendKfTypingState(String openid, String command);

}
