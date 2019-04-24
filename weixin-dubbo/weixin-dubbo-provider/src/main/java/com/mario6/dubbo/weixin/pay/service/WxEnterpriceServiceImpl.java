package com.mario6.dubbo.weixin.pay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.binarywang.wxpay.service.EntPayService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WxEnterpriceServiceImpl implements WxEnterpricePayService {

    private EntPayService entPayService;

}
