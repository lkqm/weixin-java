package com.github.lkqm.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.kefu.request.WxMpKfAccountRequest;
import me.chanjar.weixin.mp.bean.kefu.result.*;

import java.io.File;
import java.util.Date;

/**
 * 客服消息管理
 * <p>
 * 包括: 客服账户, 客服会话， 客服消息
 */
public interface WxKeFuMessageService {


    //----------------- 账户管理 ------------------------//

    /**
     * 添加客服
     */
    boolean addKfAccount(WxMpKfAccountRequest request);

    /**
     * 更新客服
     */
    boolean updateKfAccount(WxMpKfAccountRequest request);

    /**
     * 更新客服头像
     */
    boolean updateKfAccountAvater(String kfAccount, File imgFile);

    /**
     * 删除客服账号
     */
    boolean deleteKfAccount(String kfAccount);

    /**
     * 获取客服列表
     */
    WxMpKfList getKfAccountInfos();

    /**
     * 获取在线客服列表
     */
    WxMpKfOnlineList getOnlineKfAccountInfos();


    boolean kfAccountInviteWorker(WxMpKfAccountRequest request);


    //----------------- 会话管理 ------------------------//

    /**
     * 创建用户和客服会话
     */
    boolean createKfSession(String openid, String kfAccount);

    /**
     * 关闭用户和客服会话
     */
    boolean closeKfSession(String openid, String kfAccount);

    /**
     * 获取指定用户的客服会话信息
     */
    WxMpKfSessionGetResult getKfSessionByUser(String openid);

    /**
     * 获取指定客服的会话列表
     */
    WxMpKfSessionList getKfSessionsByAccount(String kfAccount);

    /**
     * 获取当前等待的客服会话
     */
    WxMpKfSessionWaitCaseList getWaitKfSessions();


    //----------------- 消息管理 ------------------------//


    /**
     * 发送客服消息
     */
    boolean sendKfMessage(WxMpKefuMessage message);

    /**
     * 发送客服输入状态
     */
    boolean sendKfTypingState(String openid, String command);

    /**
     * 获取会话消息列表
     */
    WxMpKfMsgList getKfMessages(Date startTime, Date endTime, Long msgId, Integer number);

    /**
     * 获取会话消息
     */
    WxMpKfMsgList getKfMessages(Date startTime, Date endTime);

}
