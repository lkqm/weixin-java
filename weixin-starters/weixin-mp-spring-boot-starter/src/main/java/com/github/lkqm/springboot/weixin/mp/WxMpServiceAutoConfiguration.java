package com.github.lkqm.springboot.weixin.mp;

import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号相关服务自动注册
 */
@Configuration
public class WxMpServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(WxMpConfigStorage configStorage) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);
        return wxMpService;
    }

    @Bean
    WxMpKefuService wxMpKefuService(WxMpService wxMpService) {
        return wxMpService.getKefuService();
    }

    @Bean
    WxMpMaterialService wxMpMaterialService(WxMpService wxMpService) {
        return wxMpService.getMaterialService();
    }

    @Bean
    WxMpMenuService wxMpMenuService(WxMpService wxMpService) {
        return wxMpService.getMenuService();
    }

    @Bean
    WxMpUserService wxMpUserService(WxMpService wxMpService) {
        return wxMpService.getUserService();
    }

    @Bean
    WxMpUserTagService wxMpUserTagService(WxMpService wxMpService) {
        return wxMpService.getUserTagService();
    }

    @Bean
    WxMpQrcodeService wxMpQrcodeService(WxMpService wxMpService) {
        return wxMpService.getQrcodeService();
    }

    @Bean
    WxMpCardService wxMpCardService(WxMpService wxMpService) {
        return wxMpService.getCardService();
    }

    @Bean
    WxMpDataCubeService wxMpDataCubeService(WxMpService wxMpService) {
        return wxMpService.getDataCubeService();
    }

    @Bean
    WxMpUserBlacklistService wxMpUserBlacklistService(WxMpService wxMpService) {
        return wxMpService.getBlackListService();
    }

    @Bean
    WxMpStoreService wxMpStoreService(WxMpService wxMpService) {
        return wxMpService.getStoreService();
    }

    @Bean
    WxMpTemplateMsgService wxMpTemplateMsgService(WxMpService wxMpService) {
        return wxMpService.getTemplateMsgService();
    }

    @Bean
    WxMpSubscribeMsgService wxMpSubscribeMsgService(WxMpService wxMpService) {
        return wxMpService.getSubscribeMsgService();
    }

    @Bean
    WxMpDeviceService wxMpDeviceService(WxMpService wxMpService) {
        return wxMpService.getDeviceService();
    }

    @Bean
    WxMpShakeService wxMpShakeService(WxMpService wxMpService) {
        return wxMpService.getShakeService();
    }

    @Bean
    WxMpMemberCardService wxMpMemberCardService(WxMpService wxMpService) {
        return wxMpService.getMemberCardService();
    }

    @Bean
    WxMpMassMessageService wxMpMassMessageService(WxMpService wxMpService) {
        return wxMpService.getMassMessageService();
    }

}
