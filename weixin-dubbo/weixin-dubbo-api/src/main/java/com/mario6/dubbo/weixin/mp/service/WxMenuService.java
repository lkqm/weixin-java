package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;

public interface WxMenuService {

    /**
     * 创建菜单
     */
    String menuCreate(WxMenu menu);

    /**
     * 创建菜单
     */
    String menuCreate(String json);

    /**
     * 删除菜单
     */
    void menuDelete();

    /**
     * 删除菜单
     */
    void menuDelete(String menuId);

    /**
     * 获取菜单
     */
    WxMpMenu menuGet();

    /**
     * 获取匹配用户的菜单
     */
    WxMenu menuTryMatch(String userid);

    /**
     * 获取个人菜单信息
     *
     * @return
     */
    WxMpGetSelfMenuInfoResult getSelfMenuInfo();

}
