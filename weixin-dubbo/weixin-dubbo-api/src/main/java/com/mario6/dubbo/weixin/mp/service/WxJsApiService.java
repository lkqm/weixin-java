package com.mario6.dubbo.weixin.mp.service;

import me.chanjar.weixin.common.bean.WxJsapiSignature;

/**
 * JS API支持
 */
public interface WxJsApiService {

    String getJsapiTicket();

    String getJsapiTicket(boolean forceRefresh);

    WxJsapiSignature createJsapiSignature(String url);

}
