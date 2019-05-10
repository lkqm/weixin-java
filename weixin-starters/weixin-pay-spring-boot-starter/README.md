# weixin-pay-spring-boot-starter
开源的微信开发工具[WxJava](https://github.com/Wechat-Group/WxJava)的spring-boot-starter库

支持: JDK1.7 +

## 快速开始
1. 引入依赖
    ```xml
    <dependency>
        <groupId>com.github.lkqm</groupId>
        <artifactId>weixin-pay-spring-boot-starter</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    ```
2. 添加配置(application.properties)
    ```properties
    # 是否使用沙箱环境
    wx.pay.enableSandboxEnv = false
    # 设置微信公众号或者小程序等的appid
    wx.pay.appId = 
    # 微信支付商户号
    wx.pay.mchId = 
    # 微信支付商户密钥
    wx.pay.mchKey = 
    # 服务商模式下的子商户公众账号ID，普通模式请不要配置，请在配置文件中将对应项删除
    wx.pay.subAppId = 
    # 服务商模式下的子商户号，普通模式请不要配置，最好是请在配置文件中将对应项删除
    wx.pay.subMchId = 
    # apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定
    wx.pay.keyPath = 
    ```
3. 支持自动注入的类型

`WxPayService`以及相关的服务类, 比如: `wxPayService.getXxxService`。







