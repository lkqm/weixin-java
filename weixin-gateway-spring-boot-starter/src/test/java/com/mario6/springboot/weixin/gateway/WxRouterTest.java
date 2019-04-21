package com.mario6.springboot.weixin.gateway;

import com.mario6.springboot.weixin.gateway.core.WxRouter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxRouterTest {

    @Autowired
    private WxRouter router;

    @Test
    public void route() throws InterruptedException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<xml>\n"
                + "   <ToUserName><![CDATA[gh_fc0a06a20993]]></ToUserName>\n"
                + "   <FromUserName><![CDATA[oZI8Fj040-be6rlDohc6gkoPOQTQ]]></FromUserName>\n"
                + "   <CreateTime>1475134700</CreateTime>\n"
                + "   <MsgType><![CDATA[event]]></MsgType>\n"
                + "   <Event><![CDATA[user_authorize_invoice]]></Event>\n"
                + "   <SuccOrderId><![CDATA[1202933957956]]></SuccOrderId>\n"
                + "   <FailOrderId><![CDATA[]]></FailOrderId>\n"
                + "   <AuthorizeAppId ><![CDATA[]]></AuthorizeAppId>\n"
                + "   <Source><![CDATA[]]></Source>\n"
                + "</xml>";
        router.route(xml);
        Thread.sleep(60000);
    }

}
