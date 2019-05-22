package com.github.lkqm.dubbo.weixin.mp.exception;

public class WxMpException extends RuntimeException {
    private WxError error;

    public WxMpException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxMpException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }
}