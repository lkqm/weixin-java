package com.mario6.dubbo.weixin.common.util;

import com.mario6.dubbo.weixin.common.exception.WxError;
import com.mario6.dubbo.weixin.common.exception.WxException;
import me.chanjar.weixin.common.error.WxErrorException;

public class WxErrorUtils {

    public static WxException newWxException(WxErrorException original) {
        me.chanjar.weixin.common.error.WxError orgError = original.getError();
        WxError error = newWxError(orgError);
        return new WxException(error);
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
