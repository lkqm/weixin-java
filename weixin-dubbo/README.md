# weixin-dubbo
基于dubbo服务化的微信能力, 底层使用了WxJava开源微信SDK。

## 说明
许多相关的服务接口, 底层使用了WxJava实现相关的微信访问, 封装了如下内容:

1. 异常转移: 将WxJava的CheckedException转移为WxException
