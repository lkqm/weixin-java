package com.github.lkqm.dubbo.weixin.pay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.binarywang.wxpay.bean.entpay.*;
import com.github.binarywang.wxpay.service.EntPayService;
import lombok.AllArgsConstructor;

import static com.github.lkqm.dubbo.weixin.pay.util.WxHandlerUtils.handle;

@Service
@AllArgsConstructor
public class WxEnterpriseServiceImpl implements WxEnterprisePayService {

    private EntPayService entPayService;

    @Override
    public EntPayResult entPay(EntPayRequest request) {
        return handle(() -> entPayService.entPay(request));
    }

    @Override
    public EntPayQueryResult queryEntPay(String partnerTradeNo) {
        return handle(() -> entPayService.queryEntPay(partnerTradeNo));
    }

    @Override
    public EntPayBankResult payBank(EntPayBankRequest request) {
        return handle(() -> entPayService.payBank(request));
    }

    @Override
    public EntPayBankQueryResult queryPayBank(String partnerTradeNo) {
        return handle(() -> entPayService.queryPayBank(partnerTradeNo));
    }
}
