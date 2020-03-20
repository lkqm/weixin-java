package com.github.lkqm.springboot.weixin.gateway;

import com.github.lkqm.weixin.gateway.core.WxPortalHandler;
import com.github.lkqm.weixin.gateway.core.WxRouter;
import com.github.lkqm.weixin.gateway.core.WxRouterRegister;
import com.github.lkqm.weixin.gateway.core.annotation.WxController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
    private ApplicationContext ctx;
    @Autowired
    private WxGatewayProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxRouter wxMessageRouter() {
        WxRouter router = new WxRouter();
        WxRouterRegister.create(router).register(ctx.getBeansWithAnnotation(WxController.class).values());
        return router;
    }

    @Bean
    public WxPortalHandler wxPortalHandler(WxRouter wxRouter) {
        WxPortalHandler portalHandler = new WxPortalHandler(wxRouter);
        return portalHandler;
    }

    @Bean
    @ConditionalOnWebApplication
    public WxPortalController wxPortalController(WxPortalHandler handler) {
        WxPortalController controller = new WxPortalController(handler);
        WxPortalControllerRegister.registry(ctx, controller, properties.getUri());
        return controller;
    }

}
