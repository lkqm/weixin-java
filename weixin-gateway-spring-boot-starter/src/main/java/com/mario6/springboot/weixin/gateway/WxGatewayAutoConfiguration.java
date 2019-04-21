package com.mario6.springboot.weixin.gateway;

import com.mario6.springboot.weixin.gateway.annotation.WxController;
import com.mario6.springboot.weixin.gateway.core.WxPortalController;
import com.mario6.springboot.weixin.gateway.core.WxPortalControllerRegister;
import com.mario6.springboot.weixin.gateway.core.WxRouter;
import com.mario6.springboot.weixin.gateway.core.WxRouterRegister;
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
    private WxGatewayProperties properties;
    @Autowired
    private ApplicationContext ctx;

    @Bean
    @ConditionalOnMissingBean(WxRouter.class)
    public WxRouter wxMessageRouter() {
        WxRouter router = new WxRouter();
        WxRouterRegister.create(router).registry(ctx.getBeansWithAnnotation(WxController.class).values());
        return router;
    }

    @Bean
    @ConditionalOnWebApplication
    public WxPortalController wxPortalController() {
        WxPortalController wxPortal = new WxPortalController();
        WxPortalControllerRegister.registry(ctx, wxPortal, properties.getUri());
        return wxPortal;
    }
}
