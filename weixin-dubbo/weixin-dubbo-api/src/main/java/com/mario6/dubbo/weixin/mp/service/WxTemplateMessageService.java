package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateIndustry;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

public interface WxTemplateMessageService {

    /**
     * 发送模版消息
     */
    String sendTemplateMsg(WxMpTemplateMessage templateMessage);

    /**
     * 添加一个消息模版
     */
    String addTemplate(String template);

    /**
     * 删除模版
     */
    boolean delPrivateTemplate(String templateId);

    /**
     * 获得所有模版
     */
    List<WxMpTemplate> getAllPrivateTemplate();

    /**
     * 设置所属行业
     */
    boolean setIndustry(WxMpTemplateIndustry wxMpIndustry);

    /**
     * 获取设置的行业信息
     */
    WxMpTemplateIndustry getIndustry();

}
