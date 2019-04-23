package com.mario6.weixin.gateway.core.handler;

import com.mario6.weixin.gateway.base.message.*;
import com.mario6.weixin.gateway.core.annotation.WxController;
import com.mario6.weixin.gateway.core.annotation.WxMessage;

/**
 * 普通消息处理
 */
@WxController
public class MessageHandler {

    @WxMessage(msgType = "text")
    public void text(TextMessage textMessage) {
    }

    @WxMessage(msgType = "image")
    public void image(ImageMessage imageMessage) {
    }

    @WxMessage(msgType = "voice")
    public void voice(VoiceMessage voiceMessage) {
    }

    @WxMessage(msgType = "video")
    public void video(VideoMessage videoMessage) {
    }

    @WxMessage(msgType = "shortvideo")
    public void shortVideo(VideoMessage videoMessage) {
    }

    @WxMessage(msgType = "link")
    public void link(LinkMessage linkMessage) {
    }

    @WxMessage(msgType = "location")
    public void location(LocationMessage locationMessage) {
    }
}
