package com.mario6.weixin.springboot.gateway;

import com.mario6.weixin.springboot.gateway.annotation.WxController;
import com.mario6.weixin.springboot.gateway.core.WxPortalController;
import com.mario6.weixin.springboot.gateway.core.WxRouter;
import com.mario6.weixin.springboot.gateway.core.WxRouterRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Configuration
@EnableConfigurationProperties(WxGatewayProperties.class)
@Slf4j
public class WxGatewayAutoConfiguration {

    @Autowired
    private WxGatewayProperties properties;
    @Autowired
    private ApplicationContext context;

    @Bean
    @ConditionalOnMissingBean(WxRouter.class)
    public WxRouter wxMessageRouter() {
        log.info("开始初始化微信消息路由");
        WxRouter router = new WxRouter();
        WxRouterRegister.create(router)
                .registry(context.getBeansWithAnnotation(WxController.class).values());
        return router;
    }

    @Bean
    public WxPortalController wxPortalController() {
        return new WxPortalController();
    }

    @Bean
    @ConditionalOnWebApplication
    public Object registerController(WxPortalController portalController) {
        RequestMappingHandlerMapping handler = context.getBean(RequestMappingHandlerMapping.class);

        String uri = properties.getUri();
        PatternsRequestCondition uriHttp = new PatternsRequestCondition(uri);
        Method get = null, post = null;
        // get method
        Method[] methods = portalController.getClass().getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.equalsIgnoreCase("get")) {
                get = method;
            } else if (name.equalsIgnoreCase("post")) {
                post = method;
            }
        }

        if (get == null || post == null) {
            throw new RuntimeException("微信入口控制器无效, 无法找到get, post方法");
        }

        // get method
        RequestMethodsRequestCondition getHttp = new RequestMethodsRequestCondition(
                RequestMethod.GET);
        RequestMappingInfo getMappingInfo = new RequestMappingInfo(uriHttp, getHttp, null, null,
                null, null, null);
        handler.registerMapping(getMappingInfo, portalController, get);

        // post method
        RequestMethodsRequestCondition postHttp = new RequestMethodsRequestCondition(
                RequestMethod.POST);
        RequestMappingInfo postMappingInfo = new RequestMappingInfo(uriHttp, postHttp, null, null,
                null, null, null);
        handler.registerMapping(postMappingInfo, portalController, post);

        return handler;
    }

}
