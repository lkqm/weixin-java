package com.mario6.weixin.gateway.base;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class WxXmlMessage implements Serializable {

    private static final long serialVersionUID = -3586245291677274914L;

    /**
     * xml转化为的map数据
     */
    @XmlTransient
    private Map<String, String> xmlMapData;

    /**
     * 原始的xml数据
     */
    @XmlTransient
    private String xmlData;

    @XmlElement(name = "ToUserName")
    private String toUserName;

    @XmlElement(name = "FromUserName")
    private String fromUserName;

    @XmlElement(name = "CreateTime")
    private Long createTime;

    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "Content")
    private String content;

    @XmlElement(name = "MenuId")
    private Long menuId;

    @XmlElement(name = "MsgId")
    private Long msgId;

    @XmlElement(name = "PicUrl")
    private String picUrl;

    @XmlElement(name = "MediaId")
    private String mediaId;

    @XmlElement(name = "Format")
    private String format;

    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    @XmlElement(name = "Location_X")
    private Double locationX;

    @XmlElement(name = "Location_Y")
    private Double locationY;

    @XmlElement(name = "Scale")
    private Double scale;

    @XmlElement(name = "Label")
    private String label;

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "Url")
    private String url;

    @XmlElement(name = "Event")
    private String event;

    @XmlElement(name = "EventKey")
    private String eventKey;

    @XmlElement(name = "Ticket")
    private String ticket;

    @XmlElement(name = "Latitude")
    private Double latitude;

    @XmlElement(name = "Longitude")
    private Double longitude;

    @XmlElement(name = "Precision")
    private Double precision;

    @XmlElement(name = "Recognition")
    private String recognition;

    @XmlElement(name = "UnionId")
    private String unionId;

    ///////////////////////////////////////
    // 群发消息返回的结果
    ///////////////////////////////////////
    /**
     * 群发的结果.
     */
    @XmlElement(name = "Status")
    private String status;
    /**
     * group_id下粉丝数；或者openid_list中的粉丝数.
     */
    @XmlElement(name = "TotalCount")
    private Integer totalCount;
    /**
     * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数. 原则上，filterCount = sentCount + errorCount
     */
    @XmlElement(name = "FilterCount")
    private Integer filterCount;
    /**
     * 发送成功的粉丝数.
     */
    @XmlElement(name = "SentCount")
    private Integer sentCount;
    /**
     * 发送失败的粉丝数.
     */
    @XmlElement(name = "ErrorCount")
    private Integer errorCount;

    ///////////////////////////////////////
    // 客服会话管理相关事件推送
    ///////////////////////////////////////
    /**
     * 创建或关闭客服会话时的客服帐号.
     */
    @XmlElement(name = "KfAccount")
    private String kfAccount;
    /**
     * 转接客服会话时的转入客服帐号.
     */
    @XmlElement(name = "ToKfAccount")
    private String toKfAccount;
    /**
     * 转接客服会话时的转出客服帐号.
     */
    @XmlElement(name = "FromKfAccount")
    private String fromKfAccount;

    ///////////////////////////////////////
    // 卡券相关事件推送
    ///////////////////////////////////////

    @XmlElement(name = "CardId")
    private String cardId;

    @XmlElement(name = "FriendUserName")
    private String friendUserName;

    /**
     * 是否为转赠，1代表是，0代表否.
     */
    @XmlElement(name = "IsGiveByFriend")
    private Integer isGiveByFriend;

    @XmlElement(name = "UserCardCode")
    private String userCardCode;

    @XmlElement(name = "OldUserCardCode")
    private String oldUserCardCode;

    @XmlElement(name = "OuterId")
    private Integer outerId;

    /**
     * 用户删除会员卡后可重新找回，当用户本次操作为找回时，该值为1，否则为0.
     */
    @XmlElement(name = "IsRestoreMemberCard")
    private String isRestoreMemberCard;

    /**
     * <pre>
     * 领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加Addcard接口中自定义该字段的字符串值.
     * 核销卡券时：开发者发起核销时传入的自定义参数，用于进行核销渠道统计
     * 另外：
     * 官网文档中，微信卡券>>卡券事件推送>>2.7 进入会员卡事件推送 user_view_card
     * OuterStr：商户自定义二维码渠道参数，用于标识本次扫码打开会员卡来源来自于某个渠道值的二维码
     * </pre>
     */
    @XmlElement(name = "OuterStr")
    private String outerStr;

    /**
     * 是否转赠退回，0代表不是，1代表是.
     */
    @XmlElement(name = "IsReturnBack")
    private String isReturnBack;

    /**
     * 是否是群转赠，0代表不是，1代表是.
     */
    @XmlElement(name = "IsChatRoom")
    private String isChatRoom;

    /**
     * 核销来源. 支持开发者统计API核销（FROM_API）、公众平台核销（FROM_MP）、卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）
     */
    @XmlElement(name = "ConsumeSource")
    private String consumeSource;

    /**
     * 门店名称. 当前卡券核销的门店名称（只有通过自助核销和买单核销时才会出现该字段）
     */
    @XmlElement(name = "LocationName")
    private String locationName;

    /**
     * 核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）.
     */
    @XmlElement(name = "StaffOpenId")
    private String staffOpenId;

    /**
     * 自助核销时，用户输入的验证码.
     */
    @XmlElement(name = "VerifyCode")
    private String verifyCode;

    /**
     * 自助核销时，用户输入的备注金额.
     */
    @XmlElement(name = "RemarkAmount")
    private String remarkAmount;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.10 库存报警事件card_sku_remind
     * Detail：报警详细信息.
     * </pre>
     */
    @XmlElement(name = "Detail")
    private String detail;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBonus：变动的积分值.
     * </pre>
     */
    @XmlElement(name = "ModifyBonus")
    private String modifyBonus;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBalance：变动的余额值.
     * </pre>
     */
    @XmlElement(name = "ModifyBalance")
    private String modifyBalance;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * TransId：微信支付交易订单号（只有使用买单功能核销的卡券才会出现）.
     * </pre>
     */
    @XmlElement(name = "TransId")
    private String transId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * LocationId：门店ID，当前卡券核销的门店ID（只有通过卡券商户助手和买单核销时才会出现）
     * </pre>
     */
    @XmlElement(name = "LocationId")
    private String locationId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * Fee：实付金额，单位为分
     * </pre>
     */
    @XmlElement(name = "Fee")
    private String fee;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * OriginalFee：应付金额，单位为分
     * </pre>
     */
    @XmlElement(name = "OriginalFee")
    private String originalFee;

    @XmlElement(name = "ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo = new ScanCodeInfo();

    @XmlElement(name = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo = new SendPicsInfo();

    @XmlElement(name = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo = new SendLocationInfo();

    /**
     * 审核不通过原因
     */
    @XmlElement(name = "RefuseReason")
    private String refuseReason;

    /**
     * 是否为朋友推荐，0代表否，1代表是
     */
    @XmlElement(name = "IsRecommendByFriend")
    private String isRecommendByFriend;

    /**
     * 购买券点时，实际支付成功的时间
     */
    @XmlElement(name = "PayFinishTime")
    private String payFinishTime;

    /**
     * 购买券点时，支付二维码的生成时间
     */
    @XmlElement(name = "CreateOrderTime")
    private String createOrderTime;

    /**
     * 购买券点时，支付二维码的生成时间
     */
    @XmlElement(name = "Desc")
    private String desc;

    /**
     * 剩余免费券点数量
     */
    @XmlElement(name = "FreeCoinCount")
    private String freeCoinCount;

    /**
     * 剩余付费券点数量
     */
    @XmlElement(name = "PayCoinCount")
    private String payCoinCount;

    /**
     * 本次变动的免费券点数量
     */
    @XmlElement(name = "RefundFreeCoinCount")
    private String refundFreeCoinCount;

    /**
     * 本次变动的付费券点数量
     */
    @XmlElement(name = "RefundPayCoinCount")
    private String refundPayCoinCount;

    /**
     * <pre>
     *    所要拉取的订单类型 ORDER_TYPE_SYS_ADD 平台赠送券点 ORDER_TYPE_WXPAY 充值券点 ORDER_TYPE_REFUND 库存未使用回退券点
     *    ORDER_TYPE_REDUCE 券点兑换库存 ORDER_TYPE_SYS_REDUCE 平台扣减
     * </pre>
     */
    @XmlElement(name = "OrderType")
    private String orderType;

    /**
     * 系统备注，说明此次变动的缘由，如开通账户奖励、门店奖励、核销奖励以及充值、扣减。
     */
    @XmlElement(name = "Memo")
    private String memo;

    /**
     * 所开发票的详情
     */
    @XmlElement(name = "ReceiptInfo")
    private String receiptInfo;

    ///////////////////////////////////////
    // 门店审核事件推送
    ///////////////////////////////////////
    /**
     * 商户自己内部ID，即字段中的sid.
     */
    @XmlElement(name = "UniqId")
    private String storeUniqId;

    /**
     * 微信的门店ID，微信内门店唯一标示ID.
     */
    @XmlElement(name = "PoiId")
    private String poiId;

    /**
     * 审核结果，成功succ 或失败fail.
     * <p>
     * 在商品审核结果推送时，verify_ok表示审核通过，verify_not_pass表示审核未通过。
     */
    @XmlElement(name = "Result")
    private String result;

    /**
     * 成功的通知信息，或审核失败的驳回理由.
     */
    @XmlElement(name = "msg")
    private String msg;

    ///////////////////////////////////////
    // 微信认证事件推送
    ///////////////////////////////////////
    /**
     * 资质认证成功/名称认证成功: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期. 年审通知: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期，需尽快年审 认证过期失效通知:
     * 有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证
     */
    @XmlElement(name = "ExpiredTime")
    private Long expiredTime;
    /**
     * 失败发生时间 (整形)，时间戳.
     */
    @XmlElement(name = "FailTime")
    private Long failTime;
    /**
     * 认证失败的原因.
     */
    @XmlElement(name = "FailReason")
    private String failReason;

    ///////////////////////////////////////
    // 微信小店 6.1订单付款通知
    ///////////////////////////////////////
    /**
     * 订单ID.
     */
    @XmlElement(name = "OrderId")
    private String orderId;

    /**
     * 订单状态.
     */
    @XmlElement(name = "OrderStatus")
    private String orderStatus;

    /**
     * 商品ID.
     */
    @XmlElement(name = "ProductId")
    private String productId;

    /**
     * 商品SKU信息.
     */
    @XmlElement(name = "SkuInfo")
    private String skuInfo;

    ///////////////////////////////////////
    // 微信硬件平台相关事件推送
    ///////////////////////////////////////
    /**
     * 设备类型. 目前为"公众账号原始ID"
     */
    @XmlElement(name = "DeviceType")
    private String deviceType;

    /**
     * 设备ID. 第三方提供
     */
    @XmlElement(name = "DeviceID")
    private String deviceId;

    /**
     * 微信用户账号的OpenID.
     */
    @XmlElement(name = "OpenID")
    private String openId;

    @XmlElement(name = "HardWare")
    private HardWare hardWare = new HardWare();

    /**
     * 请求类型. 0：退订设备状态； 1：心跳；（心跳的处理方式跟订阅一样） 2：订阅设备状态
     */
    @XmlElement(name = "OpType")
    private Integer opType;

    /**
     * 设备状态. 0：未连接；1：已连接
     */
    @XmlElement(name = "DeviceStatus")
    private Integer deviceStatus;

    ///////////////////////////////////////
    // 小程序 审核事件
    ///////////////////////////////////////
    /**
     * 审核成功时的时间（整形），时间戳
     */
    @XmlElement(name = "SuccTime")
    private Long succTime;

    /**
     * 审核失败的原因
     */
    @XmlElement(name = "Reason")
    private String reason;

    ///////////////////////////////////////
    // 扫一扫事件推送
    ///////////////////////////////////////
    /**
     * 商品编码标准
     */
    @XmlElement(name = "KeyStandard")
    private String keyStandard;
    /**
     * 商品编码内容
     */
    @XmlElement(name = "KeyStr")
    private String keyStr;

    /**
     * 用户在微信内设置的国家
     */
    @XmlElement(name = "Country")
    private String country;

    /**
     * 用户在微信内设置的省份
     */
    @XmlElement(name = "Province")
    private String province;

    /**
     * 用户在微信内设置的城市
     */
    @XmlElement(name = "City")
    private String city;

    /**
     * 用户的性别，1为男性，2为女性，0代表未知
     */
    @XmlElement(name = "Sex")
    private String sex;

    /**
     * 打开商品主页的场景，1为扫码，2为其他打开场景（如会话、收藏或朋友圈）
     */
    @XmlElement(name = "Scene")
    private String scene;

    /**
     * 调用“获取商品二维码接口”时传入的extinfo，为标识参数
     */
    @XmlElement(name = "ExtInfo")
    private String extInfo;

    /**
     * 用户的实时地理位置信息（目前只精确到省一级），可在国家统计局网站查到对应明细： http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html
     */
    @XmlElement(name = "RegionCode")
    private String regionCode;

    /**
     * 审核未通过的原因。
     */
    @XmlElement(name = "ReasonMsg")
    private String reasonMsg;


    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ScanCodeInfo {

        /**
         * 扫描类型，一般是qrcode.
         */
        @XmlElement(name = "ScanType")
        private String scanType;

        /**
         * 扫描结果，即二维码对应的字符串信息.
         */
        @XmlElement(name = "ScanResult")
        private String scanResult;
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ExtAttr implements Serializable {

        @XmlElement(name = "Item")
        protected final List<Item> items = new ArrayList<>();

        @Data
        public static class Item implements Serializable {

            @XmlElement(name = "Name")
            private String name;

            @XmlElement(name = "Value")
            private String value;
        }
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SendPicsInfo implements Serializable {

        @XmlElement(name = "PicList")
        protected final List<Item> picList = new ArrayList<>();

        @XmlElement(name = "Count")
        private Long count;

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Item {

            @XmlElement(name = "PicMd5Sum")
            private String picMd5Sum;
        }
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SendLocationInfo implements Serializable {

        @XmlElement(name = "Location_X")
        private String locationX;

        @XmlElement(name = "Location_Y")
        private String locationY;

        @XmlElement(name = "Scale")
        private String scale;

        @XmlElement(name = "Label")
        private String label;

        @XmlElement(name = "Poiname")
        private String poiName;

    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class HardWare implements Serializable {

        /**
         * 消息展示，目前支持myrank(排行榜)
         */
        @XmlElement(name = "MessageView")
        private String messageView;
        /**
         * 消息点击动作，目前支持ranklist(点击跳转排行榜)
         */
        @XmlElement(name = "MessageAction")
        private String messageAction;

    }
}
