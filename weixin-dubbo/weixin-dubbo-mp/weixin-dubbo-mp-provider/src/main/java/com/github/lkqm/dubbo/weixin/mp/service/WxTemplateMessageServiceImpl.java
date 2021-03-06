package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

import static com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxTemplateMessageServiceImpl implements WxTemplateMessageService {

    private WxMpTemplateMsgService wxMpTemplateMsgService;

    @Override
    public String sendTemplateMessage(WxMpTemplateMessage templateMessage) {
        return handle(() -> wxMpTemplateMsgService.sendTemplateMsg(templateMessage));
    }

    @Override
    public String addTemplate(String template) {
        return handle(() -> wxMpTemplateMsgService.addTemplate(template));
    }

    @Override
    public boolean deletePrivateTemplate(String templateId) {
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
