package com.github.lkqm.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;

import java.util.List;

/**
 * 用户标签管理
 */
public interface WxUserTagService {

    //----------------- 标签管理 ------------------------//

    /**
     * 创建标签
     */
    WxUserTag createTag(String name);

    /**
     * 获取所有标签
     */
    List<WxUserTag> getTags();

    /**
     * 更新标签
     */
    Boolean updateTag(Long id, String name);

    /**
     * 删除标签
     */
    Boolean deleteTag(Long id);


    //----------------- 用户管理 ------------------------//


    /**
     * 分页获取标签下的用户信息
     */
    WxTagListUser getUsersByTagAndPage(Long id, String nextOpenid);

    /**
     * 批量给用户打标签
     */
    boolean batchTagging(Long tagId, String[] openids);

    /**
     * 批量给用户取消标签
     */
    boolean batchUntagging(Long tagId, String[] openids);

    /**
     * 获取用户的标签
     */
    List<Long> getTagsByUser(String openId);

}
