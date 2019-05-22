package com.github.lkqm.dubbo.weixin.pay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.binarywang.wxpay.bean.coupon.*;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxScanPayNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import lombok.AllArgsConstructor;

import static com.github.lkqm.dubbo.weixin.pay.util.WxHandlerUtils.handle;


@Service
@AllArgsConstructor
public class WxPayServiceImpl implements WxPayService {

    private com.github.binarywang.wxpay.service.WxPayService payService;

    @Override
    public WxPayOrderCloseResult closeOrder(String outTradeNo) {
        return handle(() -> payService.closeOrder(outTradeNo));
    }

    @Override
    public WxPayOrderQueryResult queryOrder(String transactionId, String outTradeNo) {
        return handle(() -> payService.queryOrder(transactionId, outTradeNo));
    }

    @Override
    public <T> T createOrder(WxPayUnifiedOrderRequest request) {
        return handle(() -> payService.createOrder(request));
    }

    @Override
    public WxPayUnifiedOrderResult unifiedOrder(WxPayUnifiedOrderRequest request) {
        return handle(() -> payService.unifiedOrder(request));
    }

    @Override
    public WxPayRefundResult refund(WxPayRefundRequest request) {
        return handle(() -> payService.refund(request));
    }

    @Override
    public WxPayRefundQueryResult refundQuery(WxPayRefundQueryRequest request) {
        return handle(() -> payService.refundQuery(request));
    }

    @Override
    public WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData) {
        return handle(() -> payService.parseOrderNotifyResult(xmlData));
    }

    @Override
    public WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData) {
        return handle(() -> payService.parseRefundNotifyResult(xmlData));
    }

    @Override
    public WxScanPayNotifyResult parseScanPayNotifyResult(String xmlData) {
        return handle(() -> payService.parseScanPayNotifyResult(xmlData));
    }

    @Override
    public WxPaySendRedpackResult sendRedpack(WxPaySendRedpackRequest request) {
        return handle(() -> payService.sendRedpack(request));
    }

    @Override
    public WxPayRedpackQueryResult queryRedpack(String mchBillNo) {
        return handle(() -> payService.queryRedpack(mchBillNo));
    }

    @Override
    public String downloadRawBill(WxPayDownloadBillRequest request) {
        return handle(() -> payService.downloadRawBill(request));
    }

    @Override
    public WxPayBillResult downloadBill(WxPayDownloadBillRequest request) {
        return handle(() -> payService.downloadBill(request));
    }

    @Override
    public WxPayFundFlowResult downloadFundFlow(String billDate, String accountType, String tarType) {
        return handle(() -> payService.downloadFundFlow(billDate, accountType, tarType));
    }

    @Override
    public WxPayMicropayResult micropay(WxPayMicropayRequest request) {
        return handle(() -> payService.micropay(request));
    }

    @Override
    public WxPayOrderReverseResult reverseOrder(WxPayOrderReverseRequest request) {
        return handle(() -> payService.reverseOrder(request));
    }

    @Override
    public String shorturl(String url) {
        return handle(() -> payService.shorturl(url));
    }

    @Override
    public WxPayCouponSendResult sendCoupon(WxPayCouponSendRequest request) {
        return handle(() -> payService.sendCoupon(request));
    }

    @Override
    public WxPayCouponStockQueryResult queryCouponStock(WxPayCouponStockQueryRequest request) {
        return handle(() -> payService.queryCouponStock(request));
    }

    @Override
    public WxPayCouponInfoQueryResult queryCouponInfo(WxPayCouponInfoQueryRequest request) {
        return handle(() -> payService.queryCouponInfo(request));
    }
}
