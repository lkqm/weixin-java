package com.mario6.dubbo.weixin.common.exception;

public class WxException extends RuntimeException {
    private WxError error;

    public WxException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }
}
