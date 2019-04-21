package com.mario6.dubbo.weixin.menu.service;

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
    public String menuCreate(WxMenu menu) {
        return handle(() -> wxMpMenuService.menuCreate(menu));
    }

    @Override
    public String menuCreate(String json) {
        return handle(() -> wxMpMenuService.menuCreate(json));
    }

    @Override
    public void menuDelete() {
        handle(() -> wxMpMenuService.menuDelete());
    }

    @Override
    public void menuDelete(String menuId) {
        handle(() -> wxMpMenuService.menuDelete(menuId));
    }

    @Override
    public WxMpMenu menuGet() {
        return handle(() -> wxMpMenuService.menuGet());
    }

    @Override
    public WxMenu menuTryMatch(String userid) {
        return handle(() -> wxMpMenuService.menuTryMatch(userid));
    }

    @Override
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() {
        return handle(() -> wxMpMenuService.getSelfMenuInfo());
    }

}
