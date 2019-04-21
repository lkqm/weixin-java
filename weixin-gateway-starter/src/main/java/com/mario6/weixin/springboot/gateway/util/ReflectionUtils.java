package com.mario6.weixin.springboot.gateway.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

/**
 * ReflectionUtils
 *
 * @author Mario Luo
 * @date 2019.01.03 12:08
 */
public class ReflectionUtils {


    public static <T> T getAnnotation(Annotation[] annotations, Class<T> targetClass) {
        for (Annotation one : annotations) {
            if (targetClass.isAssignableFrom(one.annotationType())) {
                return (T) one;
            }
        }
        return null;
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void copyProperties(Object sources, Object target) {
        try {
            BeanUtils.copyProperties(target, sources);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得类型的默认值
     */
    public static Object getTypeDefaultValue(Class type) {
        if (!type.isPrimitive()) {
            return null;
        }
        if (byte.class == type) {
            return (byte) 0;
        } else if (char.class == type) {
            return '\u0000';
        } else if (short.class == type) {
            return (short) 0;
        } else if (int.class == type) {
            return 0;
        } else if (long.class == type) {
            return 0L;
        } else if (double.class == type) {
            return 0D;
        } else if (float.class == type) {
            return 0F;
        } else if (boolean.class == type) {
            return true;
        } else {
            return null;
        }
    }
}
