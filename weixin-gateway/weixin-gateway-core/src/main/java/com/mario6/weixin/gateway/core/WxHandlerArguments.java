package com.mario6.weixin.gateway.core;

import com.mario6.weixin.gateway.base.WxXmlMessage;
import com.mario6.weixin.gateway.core.annotation.WxBody;
import com.mario6.weixin.gateway.core.annotation.WxParam;
import com.mario6.weixin.gateway.core.util.JAXBUtils;
import com.mario6.weixin.gateway.core.util.ReflectionUtils;
import lombok.AllArgsConstructor;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 微信路由处理方法参数解析器
 */
@AllArgsConstructor
public class WxHandlerArguments {

    private Method method;
    private WxXmlMessage message;


    public Object[] resolveArguments() {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Object[] results = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class type = parameterTypes[i];
            Type genericType = genericParameterTypes[i];
            // 原生类型
            if (type.isPrimitive()) {
                results[i] = ReflectionUtils.getTypeDefaultValue(type);
                continue;
            }
            // WxXmlMessage类
            if (WxXmlMessage.class == type) {
                results[i] = getArgumentWxXmlMessage(message);
                continue;
            }
            // Map<String, String>
            if (Map.class == type) {
                results[i] = getArgumentMapType(message, type, genericType);
                continue;
            }
            // @XmlRootElement标注实体类
            XmlRootElement xmlRootElement = (XmlRootElement) type.getAnnotation(XmlRootElement.class);
            if (xmlRootElement != null) {
                results[i] = getArgumentJAXB(message, type);
                continue;
            }
            // 参数注解@WxParam
            Annotation[] annotations = parameterAnnotations[i];
            WxParam wxParam = ReflectionUtils.getAnnotation(annotations, WxParam.class);
            if (wxParam != null) {
                results[i] = getArgumentWithAnnotation(message, type, wxParam.value());
                continue;
            }
            // 参数注解@WxBody && String
            WxBody wxBody = ReflectionUtils.getAnnotation(annotations, WxBody.class);
            if (wxBody != null && String.class == type) {
                results[i] = message.getXmlData();
                continue;
            }
            results[i] = getArgumentOtherBean(message, type);
        }

        return results;

    }

    /**
     * 获得参数类型为WxXmlMessage
     */
    private Object getArgumentWxXmlMessage(WxXmlMessage message) {
        WxXmlMessage result = new WxXmlMessage();
        ReflectionUtils.copyProperties(message, result);
        return result;
    }

    /**
     * 获取参数类型为Map的值
     */
    private Object getArgumentMapType(WxXmlMessage message, Class type, Type genericType) {
        ParameterizedType pt = (ParameterizedType) genericType;
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        if (actualTypeArguments.length == 2) {
            // 判断泛型匹配
            Type keyType = actualTypeArguments[0];
            Type valueType = actualTypeArguments[1];
            boolean isNotMatch = (String.class != keyType && Object.class != keyType)
                    || (String.class != valueType && Object.class != valueType);
            if (isNotMatch) {
                return null;
            }
        }
        Map<String, String> map = message.getXmlMapData();
        return new HashMap(map);
    }

    /**
     * 获取参数类型为JAXB注解方式的
     */
    private Object getArgumentJAXB(WxXmlMessage message, Class type) {
        String xml = message.getXmlData();
        if (xml == null || xml.trim().length() == 0) {
            return null;
        }
        try {
            Object value = JAXBUtils.unmarshal(xml, type);
            // 避免类型不匹配
            return type == value.getClass() ? value : null;
        } catch (JAXBException e) {
            throw new RuntimeException("参数注入失败, 请查阅jaxb相关信息", e);
        }
    }

    /**
     * 获取注解@WxParam的参数的值
     */
    private Object getArgumentWithAnnotation(WxXmlMessage message, Class type, String paramName) {
        Map<String, String> xmlMap = message.getXmlMapData();
        final String key = paramName.trim();
        String value = xmlMap.get(key);
        if (String.class == type || value == null) {
            return value;
        }

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
     * 其他bean注入
     */
    private Object getArgumentOtherBean(WxXmlMessage message, Class type) {
        // ignore list, map, set, array, String, Integer,....
        Class[] ignoreTypes = {Array.class, List.class, Map.class, Set.class, String.class, Character.class,
                Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class};
        for (Class ignoreType : ignoreTypes) {
            if (ignoreType.isAssignableFrom(type)) {
                return null;
            }
        }
        Object object = ReflectionUtils.newInstance(type);
        if (object == null) {
            return null;
        }

        Map<String, String> orgMap = message.getXmlMapData();
        Map<String, String> fieldNameMap = new HashMap<>(orgMap.size());
        Iterator<Map.Entry<String, String>> it = orgMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String tagName = next.getKey();
            String filedName = tagNameToFieldName(tagName);
            fieldNameMap.put(filedName, next.getValue());
        }
        ReflectionUtils.copyProperties(fieldNameMap, object);
        return object;
    }

    private String tagNameToFieldName(String tag) {
        StringBuilder name = new StringBuilder();
        char[] chars = tag.toCharArray();
        boolean isNeedUpper = false;
        boolean isFirstChar = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '-' || c == '_' || c == '$' || c == '.') {
                isNeedUpper = true;
                continue;
            }
            if (isFirstChar) {
                name.append(Character.toLowerCase(c));
                isFirstChar = false;
                isNeedUpper = false;
                continue;
            }
            name.append(isNeedUpper ? Character.toUpperCase(c) : c);
            isNeedUpper = false;
        }
        return name.toString();
    }
}
