package com.mario6.weixin.gateway.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信消息分发: text, image, ...
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WxMessage {

    /**
     * 等价: msgType
     */
    String value() default "";

    /**
     * 消息名称
     */
    String msgType() default "";

}