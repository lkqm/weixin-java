package com.mario6.dubbo.weixin.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

import java.util.List;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxUserServiceImpl implements WxUserService {
    private WxMpUserService wxMpUserService;

    @Override
    public WxMpUser getUserInfo(String openid) {
        return handle(() -> wxMpUserService.userInfo(openid));
    }

    @Override
    public List<WxMpUser> getUserInfoList(List<String> openids) {
        return handle(() -> wxMpUserService.userInfoList(openids));
    }

    @Override
    public WxMpUserList getUserOpenidsByPage(String nextOpenid) {
        return handle(() -> wxMpUserService.userList(nextOpenid));
    }

    @Override
    public void updateUserRemark(String openid, String remark) {
        handle(() -> wxMpUserService.userUpdateRemark(openid, remark));
    }
}
