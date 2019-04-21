# weixin-gateway-starter

微信网关starter库, 基于注解方式处理回掉分发消息...

支持: JDK1.7 +

## 快速开始
1. 引入依赖
    ```xml
    <dependency>
        <groupId>com.mario6.weixin</groupId>
        <artifactId>weixin-gateway-starter</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
    ```
2. 添加配置(application.properties)
    ```properties
    wx.mp.uri = /wx/mp/api
    wx.mp.app.appId = @appId
    wx.mp.app.token = @token
    wx.mp.app.aesKey = @aesKey
    ```
3. 增加相关的业务处理器
    ```java
    @WxController
    public class InvoiceHandler {
        @WxEvent("user_authorize_invoice")
        public void authEvent(WxXmlMessage message, InvoiceAuthMessage authMessage,
                              @WxBody String xml, @WxParam("FromUserName") String fromUser,
                              @WxParam("CreateTime") Integer createTime,
                              int intValue, short shortValue, char charValue, long longValue,
                              float floatValue, double doubleValue) {
            System.out.println("@XmlRootElement: " + authMessage);
            System.out.println("@WxBody: " + xml);
            System.out.println("@WxParam('FromUserName'): " + fromUser);
            System.out.println("@WxParam('CreateTime'): " + createTime);
        }
    }
    ```

## 消息处理
### 消息分发
所有的消息分发处理均是异步。
- `@WxController`: 标记类为消息处理类
- `@WxEvent`: 注解用于事件匹配, 匹配条件的方法会被执行
- `@WxMessage`: 注解用于消息匹配, 匹配条件的方法会被执行

### 参数注入
处理微信消息(事件)的处理方法, 参数支持注入6种参数:

- 普通bean: 普通java bean, 字段命名需要按照xml标记转化为驼峰命名风格注入
- WxXmlMessage: 参数类型为`WxXmlMessage`会自动注入, 包含类微信回掉大多数场景下的消息
- @XmlRootElement: 参数类型指定了注解`@XmlRootElement(name="xml")`会被自动注入, 参见jaxb标准
- Map: 参数类型为Map时, 会将xml按照key=标签名, value=标签内容存入map, 注意Map的泛型参数只能是: String | Object
- @WxParam: 方法参数指定注解`@Wxparam`, 会自定注入指定xml标记的值
- @WxBody: 方法参数指定注解`@WxBody`, 并且类型String, 会自动注入值为微信请求的xml(非密文)

注意: 基本类型参数只会注入默认值





