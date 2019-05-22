package com.github.lkqm.dubbo.weixin.mp;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 微信能力-公众号
 */
@SpringBootApplication
@DubboComponentScan
public class WxMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxMpApplication.class, args);
    }

}
