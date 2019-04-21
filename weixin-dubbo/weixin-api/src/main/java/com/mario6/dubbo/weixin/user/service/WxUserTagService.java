package com.mario6.dubbo.weixin.user.service;

import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;

import java.util.List;

/**
 * 用户标签管理
 */
public interface WxUserTagService {

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

    /**
     * 分页获取标签下的用户信息
     *
     * @param id
     * @param nextOpenid
     * @return
     */
    WxTagListUser getUserByTagAndPage(Long id, String nextOpenid);

    /**
     * 批量给用户打标签
     */
    boolean batchTagging(Long tagId, String[] openids);

    /**
     * 批量给用户取消标签
     *
     * @param tagId
     * @param openids
     * @return
     */
    boolean batchUntagging(Long tagId, String[] openids);

    /**
     * 获取用户的标签
     *
     * @param openId
     * @return
     */
    List<Long> getTagsByUser(String openId);

}
