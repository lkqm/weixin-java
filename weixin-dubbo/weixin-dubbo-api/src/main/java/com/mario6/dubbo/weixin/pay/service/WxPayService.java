package com.mario6.dubbo.weixin.pay.service;

import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;

/**
 * 微信支付服务
 */
public interface WxPayService {

    //----------------订单-----------------------//

    /**
     * 关闭订单
     */
    WxPayOrderCloseResult closeOrder(String outTradeNo);

    /**
     * 查询订单信息
     */
    WxPayOrderQueryResult queryOrder(String transactionId, String outTradeNo);

    /**
     * 创建订单
     */
    <T> T createOrder(WxPayUnifiedOrderRequest request);

    /**
     * 统一下单
     */
    WxPayUnifiedOrderResult unifiedOrder(WxPayUnifiedOrderRequest request);

    /**
     * 解析订单通知结果
     */
    WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData);

    //----------------退款-----------------------//

    /**
     * 微信支付-申请退款
     */
    WxPayRefundResult refund(WxPayRefundRequest request);

    /**
     * 微信支付-退款查询
     */
    WxPayRefundQueryResult refundQuery(WxPayRefundQueryRequest request);

    /**
     * 解析退款通知结果
     */
    WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData);

    /**
     * 解析扫码支付通知结果
     */
    WxScanPayNotifyResult parseScanPayNotifyResult(String xmlData);

    /**
     * 发送红包
     */
    WxPaySendRedpackResult sendRedpack(WxPaySendRedpackRequest request);

    /**
     * 红包查询
     */
    WxPayRedpackQueryResult queryRedpack(String mchBillNo);

    /**
     * 下载对账单
     */
    String downloadRawBill(WxPayDownloadBillRequest request);

    /**
     * 下载对账单
     */
    WxPayBillResult downloadBill(WxPayDownloadBillRequest request);

    /**
     * 下载资金账单
     */
    WxPayFundFlowResult downloadFundFlow(String billDate, String accountType, String tarType);

    /**
     * 提交刷卡支付
     */
    WxPayMicropayResult micropay(WxPayMicropayRequest request);

    /**
     * 撤销订单
     */
    WxPayOrderReverseResult reverseOrder(WxPayOrderReverseRequest request);

    /**
     * 短链接
     */
    String shorturl(String url);

    /**
     * 发放优惠卷
     */
    WxPayCouponSendResult sendCoupon(WxPayCouponSendRequest request);

    /**
     * 查询代金券批次
     */
    WxPayCouponStockQueryResult queryCouponStock(WxPayCouponStockQueryRequest request);

    /**
     * 查询代金券信息
     */
    WxPayCouponInfoQueryResult queryCouponInfo(WxPayCouponInfoQueryRequest request);

}
