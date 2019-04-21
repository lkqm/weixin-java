package com.mario6.dubbo.weixin.shorturl;

import com.mario6.dubbo.weixin.wxmp.service.WxShortUrlService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WxShortUrlServiceImplTest {

    @Resource
    private WxShortUrlService wxShortUrlService;

    @Test
    public void shortUrl() {
        String url = wxShortUrlService.shortUrl("http://www.baidu.com");
        assertTrue(StringUtils.isNotBlank(url));
    }
}