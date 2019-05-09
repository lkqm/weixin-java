package com.github.lkqm.springboot.weixin.gateway;

import com.github.lkqm.weixin.gateway.core.WxGatewayConfig;
import com.github.lkqm.weixin.gateway.core.WxPortalHandler;
import com.github.lkqm.weixin.gateway.core.WxRouter;
import com.github.lkqm.weixin.gateway.core.WxRouterRegister;
import com.github.lkqm.weixin.gateway.core.annotation.WxController;
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
        WxGatewayConfig wxConfig = getWxMpConfig();
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

    private WxGatewayConfig getWxMpConfig() {
        WxGatewayProperties app = properties;
        WxGatewayConfig wxConfig = WxGatewayConfig.builder()
                .dev(app.isDev())
                .appId(app.getAppId())
                .token(app.getToken())
                .aesKey(app.getAesKey())
                .build();
        return wxConfig;
    }
}
