package com.github.lkqm.dubbo.weixin.pay;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 微信能力-支付服务
 */
@SpringBootApplication
@DubboComponentScan
public class WxPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxPayApplication.class, args);
    }

}
