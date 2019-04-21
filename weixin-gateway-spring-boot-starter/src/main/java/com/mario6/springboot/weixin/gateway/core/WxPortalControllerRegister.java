package com.mario6.springboot.weixin.gateway.core;

import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WxPortalControllerRegister {

    private static final String GET_METHOD_NAME = "get";
    private static final String POST_METHOD_NAME = "post";

    public static void registry(ApplicationContext ctx, WxPortalController portalController, String uri) {
        Map<String, Method> handleMethods = getAndCheckTargetMethod(portalController.getClass());
        Method get = handleMethods.get(GET_METHOD_NAME);
        Method post = handleMethods.get(POST_METHOD_NAME);

        RequestMappingHandlerMapping handler = ctx.getBean(RequestMappingHandlerMapping.class);
        PatternsRequestCondition uriHttp = new PatternsRequestCondition(uri);

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
    }

    private static Map<String, Method> getAndCheckTargetMethod(Class clazz) {
        Map<String, Method> keyToMethodMap = new HashMap<String, Method>();

        Method[] methods = ReflectionUtils.getAllDeclaredMethods(clazz);
        for (Method method : methods) {
            String name = method.getName();
            if (name.equalsIgnoreCase(GET_METHOD_NAME)) {
                keyToMethodMap.put(GET_METHOD_NAME, method);
            } else if (name.equalsIgnoreCase(POST_METHOD_NAME)) {
                keyToMethodMap.put(POST_METHOD_NAME, method);
            }
        }

        Method get = keyToMethodMap.get(GET_METHOD_NAME);
        Method post = keyToMethodMap.get(POST_METHOD_NAME);

        if (get == null || post == null) {
            throw new RuntimeException("微信入口控制器无效, 无法找到get, post方法");
        }
        return keyToMethodMap;
    }

}
