package com.github.lkqm.dubbo.weixin.pay.util;

import com.github.lkqm.dubbo.weixin.pay.exception.WxPayException;
import org.springframework.beans.BeanUtils;

public class WxPayExceptionUtils {

    public static WxPayException newWxPayException(com.github.binarywang.wxpay.exception.WxPayException original) {
        WxPayException exception = new WxPayException("");
        BeanUtils.copyProperties(original, exception);
        return exception;
    }
}
