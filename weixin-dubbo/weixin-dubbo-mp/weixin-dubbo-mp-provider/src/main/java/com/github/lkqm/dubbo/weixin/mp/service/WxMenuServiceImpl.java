package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;


@Service
@AllArgsConstructor
public class WxMenuServiceImpl implements WxMenuService {

    private WxMpMenuService wxMpMenuService;

    @Override
    public String createMenu(WxMenu menu) {
        return WxHandlerUtils.handle(() -> wxMpMenuService.menuCreate(menu));
    }

    @Override
    public void deleteMenu() {
        WxHandlerUtils.handle(() -> wxMpMenuService.menuDelete());
    }

    @Override
    public void deleteMenu(String menuId) {
        WxHandlerUtils.handle(() -> wxMpMenuService.menuDelete(menuId));
    }

    @Override
    public WxMpMenu getMenu() {
        return WxHandlerUtils.handle(() -> wxMpMenuService.menuGet());
    }

    @Override
    public WxMenu tryMatchMenu(String userId) {
        return WxHandlerUtils.handle(() -> wxMpMenuService.menuTryMatch(userId));
    }

    @Override
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() {
        return WxHandlerUtils.handle(() -> wxMpMenuService.getSelfMenuInfo());
    }

}
