package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxMenuServiceImpl implements WxMenuService {

    private WxMpMenuService wxMpMenuService;

    @Override
    public String createMenu(WxMenu menu) {
        return handle(() -> wxMpMenuService.menuCreate(menu));
    }

    @Override
    public void deleteMenu() {
        handle(() -> wxMpMenuService.menuDelete());
    }

    @Override
    public void deleteMenu(String menuId) {
        handle(() -> wxMpMenuService.menuDelete(menuId));
    }

    @Override
    public WxMpMenu getMenu() {
        return handle(() -> wxMpMenuService.menuGet());
    }

    @Override
    public WxMenu tryMatchMenu(String userId) {
        return handle(() -> wxMpMenuService.menuTryMatch(userId));
    }

    @Override
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() {
        return handle(() -> wxMpMenuService.getSelfMenuInfo());
    }

}
