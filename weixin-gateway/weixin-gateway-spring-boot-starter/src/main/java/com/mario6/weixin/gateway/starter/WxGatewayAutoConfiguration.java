package com.mario6.weixin.gateway.starter;

import com.mario6.weixin.gateway.core.WxMpConfig;
import com.mario6.weixin.gateway.core.WxPortalHandler;
import com.mario6.weixin.gateway.core.WxRouter;
import com.mario6.weixin.gateway.core.WxRouterRegister;
import com.mario6.weixin.gateway.core.annotation.WxController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WxGatewayProperties.class)
@Slf4j
public class WxGatewayAutoConfiguration {

    @Autowired
    private WxGatewayProperties properties;
    @Autowired
    private ApplicationContext ctx;

    @Bean
    public WxRouter wxMessageRouter() {
        WxRouter router = new WxRouter();
        WxRouterRegister.create(router).registry(ctx.getBeansWithAnnotation(WxController.class).values());
        return router;
    }

    @Bean
    public WxPortalHandler wxPortalHandler(WxRouter wxRouter) {
        WxMpConfig wxConfig = getWxMpConfig();
        WxPortalHandler portalHandler = new WxPortalHandler(wxConfig, wxRouter);
        return portalHandler;
    }

    @Bean
    @ConditionalOnWebApplication
    public WxPortalController wxPortalController(WxPortalHandler handler) {
        WxPortalController controller = new WxPortalController(handler);
        WxPortalControllerRegister.registry(ctx, controller, properties.getUri());
        return controller;
    }

    private WxMpConfig getWxMpConfig() {
        WxGatewayProperties.AppConfig app = properties.getApp();
        WxMpConfig wxConfig = WxMpConfig.builder()
                .appId(app.getAppId())
                .token(app.getToken())
                .aesKey(app.getAesKey())
                .build();
        return wxConfig;
    }
}
