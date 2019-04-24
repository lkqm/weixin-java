package com.mario6.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpUserTagService;
import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;

import java.util.List;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxUserTagServiceImpl implements WxUserTagService {

    private WxMpUserTagService wxMpUserTagService;

    @Override
    public WxUserTag createTag(String name) {
        return handle(() -> wxMpUserTagService.tagCreate(name));
    }

    @Override
    public List<WxUserTag> getTags() {
        return handle(() -> wxMpUserTagService.tagGet());
    }

    @Override
    public Boolean updateTag(Long id, String name) {
        return handle(() -> wxMpUserTagService.tagUpdate(id, name));
    }

    @Override
    public Boolean deleteTag(Long id) {
        return handle(() -> wxMpUserTagService.tagDelete(id));
    }

    @Override
    public WxTagListUser getUserByTagAndPage(Long id, String nextOpenid) {
        return handle(() -> wxMpUserTagService.tagListUser(id, nextOpenid));
    }

    @Override
    public boolean batchTagging(Long tagId, String[] openids) {
        return handle(() -> wxMpUserTagService.batchTagging(tagId, openids));
    }

    @Override
    public boolean batchUntagging(Long tagId, String[] openids) {
        return handle(() -> wxMpUserTagService.batchUntagging(tagId, openids));
    }

    @Override
    public List<Long> getTagsByUser(String openId) {
        return handle(() -> wxMpUserTagService.userTagList(openId));
    }
}
