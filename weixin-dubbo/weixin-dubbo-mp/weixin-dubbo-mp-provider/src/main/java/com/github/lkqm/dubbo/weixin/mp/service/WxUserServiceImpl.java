package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

import java.util.List;

@Service
@AllArgsConstructor
public class WxUserServiceImpl implements WxUserService {
    private WxMpUserService wxMpUserService;

    @Override
    public WxMpUser getUserInfo(String openid) {
        return WxHandlerUtils.handle(() -> wxMpUserService.userInfo(openid));
    }

    @Override
    public List<WxMpUser> getUserInfoList(List<String> openids) {
        return WxHandlerUtils.handle(() -> wxMpUserService.userInfoList(openids));
    }

    @Override
    public WxMpUserList getUserOpenidsByPage(String nextOpenid) {
        return WxHandlerUtils.handle(() -> wxMpUserService.userList(nextOpenid));
    }

    @Override
    public void updateUserRemark(String openid, String remark) {
        WxHandlerUtils.handle(() -> wxMpUserService.userUpdateRemark(openid, remark));
    }
}
