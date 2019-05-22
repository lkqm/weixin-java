package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpUserTagService;
import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;

import java.util.List;

@Service
@AllArgsConstructor
public class WxUserTagServiceImpl implements WxUserTagService {

    private WxMpUserTagService wxMpUserTagService;

    @Override
    public WxUserTag createTag(String name) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.tagCreate(name));
    }

    @Override
    public List<WxUserTag> getTags() {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.tagGet());
    }

    @Override
    public Boolean updateTag(Long id, String name) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.tagUpdate(id, name));
    }

    @Override
    public Boolean deleteTag(Long id) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.tagDelete(id));
    }

    @Override
    public WxTagListUser getUsersByTagAndPage(Long id, String nextOpenid) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.tagListUser(id, nextOpenid));
    }

    @Override
    public boolean batchTagging(Long tagId, String[] openids) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.batchTagging(tagId, openids));
    }

    @Override
    public boolean batchUntagging(Long tagId, String[] openids) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.batchUntagging(tagId, openids));
    }

    @Override
    public List<Long> getTagsByUser(String openId) {
        return WxHandlerUtils.handle(() -> wxMpUserTagService.userTagList(openId));
    }
}
