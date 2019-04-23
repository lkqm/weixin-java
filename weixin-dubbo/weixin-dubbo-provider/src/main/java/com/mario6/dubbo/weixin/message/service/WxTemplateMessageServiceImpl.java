package com.mario6.dubbo.weixin.message.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

import static com.mario6.dubbo.weixin.common.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxTemplateMessageServiceImpl implements WxTemplateMessageService {

    private WxMpTemplateMsgService wxMpTemplateMsgService;

    @Override
    public String sendTemplateMsg(WxMpTemplateMessage templateMessage) {
        return handle(() -> wxMpTemplateMsgService.sendTemplateMsg(templateMessage));
    }

    @Override
    public String addTemplate(String template) {
        return handle(() -> wxMpTemplateMsgService.addTemplate(template));
    }

    @Override
    public boolean delPrivateTemplate(String templateId) {
        return handle(() -> wxMpTemplateMsgService.delPrivateTemplate(templateId));
    }

    @Override
    public boolean setIndustry(WxMpTemplateIndustry wxMpIndustry) {
        return handle(() -> wxMpTemplateMsgService.setIndustry(wxMpIndustry));
    }

    @Override
    public WxMpTemplateIndustry getIndustry() {
        return handle(() -> wxMpTemplateMsgService.getIndustry());
    }

    @Override
    public List<WxMpTemplate> getAllPrivateTemplate() {
        return null;
    }
}
