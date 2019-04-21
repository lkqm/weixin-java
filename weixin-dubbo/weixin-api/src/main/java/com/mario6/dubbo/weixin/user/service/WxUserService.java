package com.mario6.dubbo.weixin.user.service;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

import java.util.List;

/**
 * 微信用户管理
 */
public interface WxUserService {

    /**
     * 获取用户信息
     */
    WxMpUser getUserInfo(String openid);

    /**
     * 获取用户信息列表
     */
    List<WxMpUser> getUserInfoList(List<String> openids);

    /**
     * 分页获取关注的用户列表
     *
     * @param nextOpenid 下一次读取的openid
     * @return
     */
    WxMpUserList getUserOpenidsByPage(String nextOpenid);

    /**
     * 更新对用户的备注
     */
    void updateUserRemark(String openid, String remark);

}
