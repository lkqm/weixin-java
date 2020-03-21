package com.github.lkqm.springboot.weixin.gateway;

import com.github.lkqm.weixin.gateway.WxPortalHandler;
import com.github.lkqm.weixin.gateway.WxRegister;
import com.github.lkqm.weixin.gateway.WxRouter;
import com.github.lkqm.weixin.gateway.annotation.WxController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(WxGatewayProperties.class)
@Slf4j
public class WxGatewayAutoConfiguration {

    @Resource
    private ApplicationContext ctx;

    @Bean
    @ConditionalOnMissingBean
    public WxRouter wxMessageRouter() {
        WxRouter router = new WxRouter();
        WxRegister.create(router).register(ctx.getBeansWithAnnotation(WxController.class).values());
        return router;
    }

    @Bean
    public WxPortalHandler wxPortalHandler(WxRouter wxRouter) {
        WxPortalHandler portalHandler = new WxPortalHandler(wxRouter);
        return portalHandler;
    }

    @Bean
    public WxPortalController wxPortalController(WxPortalHandler handler, WxGatewayProperties properties) {
        return new WxPortalController(handler, properties);
    }

}
