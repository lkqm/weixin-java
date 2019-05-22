package com.github.lkqm.dubbo.weixin.mp.util;

import com.github.lkqm.dubbo.weixin.mp.exception.WxError;
import com.github.lkqm.dubbo.weixin.mp.exception.WxMpException;
import me.chanjar.weixin.common.error.WxErrorException;

public class WxMpExceptionUtils {

    public static WxMpException newWxException(WxErrorException original) {
        me.chanjar.weixin.common.error.WxError orgError = original.getError();
        WxError error = newWxError(orgError);
        return new WxMpException(error);
    }

    public static WxError newWxError(me.chanjar.weixin.common.error.WxError original) {
        if (original == null) return null;
        WxError error = new WxError();
        error.setErrorCode(original.getErrorCode());
        error.setErrorMsg(original.getErrorMsg());
        error.setErrorMsgEn(original.getErrorMsgEn());
        error.setJson(original.getJson());
        return error;
    }

}
