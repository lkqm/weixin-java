package com.github.lkqm.dubbo.weixin.pay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.binarywang.wxpay.service.EntPayService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WxEnterpriseServiceImpl implements WxEnterprisePayService {

    private EntPayService entPayService;

}
