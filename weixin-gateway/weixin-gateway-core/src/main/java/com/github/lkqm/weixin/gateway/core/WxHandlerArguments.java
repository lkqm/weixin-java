package com.github.lkqm.weixin.gateway.core;

import com.alibaba.fastjson.JSONObject;
import com.github.lkqm.weixin.gateway.core.annotation.WxBody;
import com.github.lkqm.weixin.gateway.core.annotation.WxParam;
import com.github.lkqm.weixin.gateway.core.util.ReflectionUtils;
import lombok.AllArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 微信路由处理方法参数解析器
 */
@AllArgsConstructor
public class WxHandlerArguments {

    private Method method;
    private WxRouteMessage message;

    public Object[] resolveArguments() {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Object[] results = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class type = parameterTypes[i];
            // 原生类型
            if (type.isPrimitive()) {
                results[i] = ReflectionUtils.getTypeDefaultValue(type);
                continue;
            }
            // 参数注解@WxBody && String
            Annotation[] annotations = parameterAnnotations[i];
            WxBody wxBody = ReflectionUtils.getAnnotation(annotations, WxBody.class);
            if (wxBody != null && String.class == type) {
                results[i] = message.getXml();
                continue;
            }
            // 参数注解@WxParam
            WxParam wxParam = ReflectionUtils.getAnnotation(annotations, WxParam.class);
            if (wxParam != null) {
                results[i] = getArgumentWithAnnotation(message, type, wxParam.value());
                continue;
            }
            results[i] = getArgumentJavaBean(message, type);
        }

        return results;
    }

    /**
     * 获取注解@WxParam的参数的值
     */
    private Object getArgumentWithAnnotation(WxRouteMessage message, Class type, String paramName) {
        Map<String, Object> xmlMap = message.getXmlMap();
        final String key = paramName.trim();
        Object orgValue = xmlMap.get(key);

        if (orgValue.getClass() != String.class) return null;
        if (String.class == type || orgValue == null) {
            return orgValue;
        }

        String value = (String) orgValue;
        Object result = null;
        try {
            final String numberValue = value.trim();
            if (byte.class == type || Byte.class == type) {
                result = Byte.valueOf(numberValue);
            } else if ((char.class == type || Character.class == type)
                    && numberValue.length() == 0) {
                result = Character.valueOf(numberValue.charAt(0));
            } else if (short.class == type || Short.class == type) {
                result = Short.valueOf(numberValue);
            } else if (int.class == type || Integer.class == type) {
                result = Integer.valueOf(numberValue);
            } else if (long.class == type || Long.class == type) {
                result = Long.valueOf(numberValue);
            } else if (float.class == type || Float.class == type) {
                result = Float.valueOf(numberValue);
            } else if (double.class == type || Double.class == type) {
                result = Double.valueOf(numberValue);
            } else if (boolean.class == type || Boolean.class == type) {
                result = Boolean.valueOf(numberValue);
            }
        } catch (NumberFormatException ex) {
        }
        return result;
    }

    /**
     * 普通Bean注入, 按照驼峰命名
     */
    private Object getArgumentJavaBean(WxRouteMessage message, Class type) {
        Class[] ignoreTypes = {Array.class, List.class, Map.class, Set.class, String.class, Character.class,
                Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class};
        for (Class ignoreType : ignoreTypes) {
            if (ignoreType.isAssignableFrom(type)) {
                return null;
            }
        }

        String json = message.getCamelJson();
        if (json == null) return null;

        return JSONObject.parseObject(json, type);
    }

}
