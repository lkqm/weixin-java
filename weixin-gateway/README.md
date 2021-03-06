# weixin-gateway
一个基于注解进行微信消息或事件通知的网关。

```java
    @WxController
    public class InvoiceHandler {
        @WxEvent("user_authorize_invoice")
        public void authorEvent(InvoiceAuthEventMessage message) {
            System.out.println("电子发票授权事件");
        }
    }
```

支持: JDK1.7 +

脚手架项目: [weixin-gateway-web](https://github.com/lkqm/weixin-java/tree/master/weixin-gateway/weixin-gateway-web)

## 快速开始(spring-boot项目)
1. 引入依赖
    ```xml
    <dependency>
        <groupId>com.github.lkqm</groupId>
        <artifactId>weixin-gateway-spring-boot-starter</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    ```
2. 添加配置(application.properties)
    ```properties
    wx.gateway.enabled = ture              # 是否开启, 关闭后不会自动注入WxPortalController
    wx.gateway.dev = false                 # 开发者模式, 处理消息跳过签名校验
    wx.gateway.prefix = /wx/gateway        # 设置回掉路径前缀, 完整地址: /wx/gateway/{key}
    wx.gateway.config.KEY1.appId = @appId  # 配置一个微信配置访问路径key=KEY1
    wx.gateway.config.KEY1.token = @token
    wx.gateway.config.KEY1.aesKey = @aesKey
    
    wx.gateway.pool.coreSize = 10          #核心线程大小
    wx.gateway.pool.maxSize = 100          #最大线程大小
    wx.gateway.pool.keepAlive = 5000       #空闲线程存活时间(ms)
    wx.gateway.pool.queueCapacity=         #工作队列大小
    ```
3. 增加相关的业务处理器
    ```java
    @WxController
    public class InvoiceHandler {
        @WxEvent("user_authorize_invoice")
        public void authEvent(InvoiceAuthMessage authMessage, @WxBody String xml, 
                              @WxParam("FromUserName") String fromUser, @WxParam("CreateTime") Integer createTime) {
        }
    }
    ```

## 你需要知道的？
### 消息分发
所有的消息分发处理均是异步。
- `@WxController`: 标记类为消息处理类
- `@WxEvent`: 注解用于事件匹配
- `@WxMessage`: 注解用于消息匹配

### 参数注入
处理微信消息(事件)的处理方法, 参数支持注入3种参数:

- 普通bean: 普通JavaBean, 字段命名需要按照驼峰命名(内部是xml转json, 然后json转对象)
- @WxParam: 方法参数指定注解`@WxParam`, 会自定注入指定xml标记的值(不支持多层潜逃)
- @WxBody: 方法参数指定注解`@WxBody`, 并且类型String, 会自动注入值为微信请求的xml(非密文)

注意: 基本类型参数只会注入默认值





