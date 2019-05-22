package com.github.lkqm.dubbo.weixin.mp.service;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;

/**
 * 菜单管理
 */
public interface WxMenuService {

    /**
     * 创建菜单
     */
    String createMenu(WxMenu menu);

    /**
     * 删除菜单
     */
    void deleteMenu();

    /**
     * 删除菜单
     */
    void deleteMenu(String menuId);

    /**
     * 获取菜单
     */
    WxMpMenu getMenu();

    /**
     * 获取匹配用户的菜单
     */
    WxMenu tryMatchMenu(String userId);

    /**
     * 获取个人菜单信息
     *
     * @return
     */
    WxMpGetSelfMenuInfoResult getSelfMenuInfo();

}
