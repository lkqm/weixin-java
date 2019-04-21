# weixin-starter
开源的微信开发工具[WxJava](https://github.com/Wechat-Group/WxJava)的spring-boot-starter库

支持: JDK1.7 +

## 快速开始
1. 引入依赖
    ```xml
    <dependency>
        <groupId>com.mario6.weixin</groupId>
        <artifactId>weixin-spring-boot-starter</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    ```
2. 添加配置(application.properties)
    ```properties
    # 微信应用配置
    wx.mp.app.appId = @appId
    wx.mp.app.secret = @secret
    wx.mp.app.token = @token
    wx.mp.app.aesKey = @aesKey
    # 存储配置redis
    # wx.mp.storage.type = redis
    # wx.mp.storage.redis.host = 127.0.0.1
    # wx.mp.storage.redis.port = 6379
    ```
3. 支持自动注入的类型

`WxMpService`以及相关的服务类, 比如: `wxMpService.getXxxService`。






