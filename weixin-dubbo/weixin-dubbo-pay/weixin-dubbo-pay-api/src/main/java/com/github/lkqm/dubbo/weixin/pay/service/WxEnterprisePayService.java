package com.github.lkqm.dubbo.weixin.pay.service;

import com.github.binarywang.wxpay.bean.entpay.*;

/**
 * 微信企业支付服务
 */
public interface WxEnterprisePayService {

    /**
     * 企业付款
     */
    EntPayResult entPay(EntPayRequest request);

    /**
     * 查询企业付款
     */
    EntPayQueryResult queryEntPay(String partnerTradeNo);

    /**
     * 企业付款到银行卡
     */
    EntPayBankResult payBank(EntPayBankRequest request);

    /**
     * 企业付款到银行卡查询
     */
    EntPayBankQueryResult queryPayBank(String partnerTradeNo);

}
