package com.mario6.dubbo.weixin.mp.service;

import com.mario6.dubbo.weixin.mp.model.invoice.*;

/**
 * 电子发票相关的接口
 */
public interface WxInvoiceService {

    /**
     * 获取开票授权页链接
     */
    InvoiceAuthPageResult getAuthPageUrl(InvoiceAuthPageRequest params);

    /**
     * 获得用户授权数据
     */
    InvoiceAuthDataResult getAuthData(InvoiceAuthDataRequest params);

    /**
     * 拒绝开票
     * <p>
     * 场景: 用户授权填写数据无效
     * 结果: 用户会收到一条开票失败提示
     */
    void rejectInvoice(InvoiceRejectRequest params);

    /**
     * 开具电子发票
     */
    void makeOutInvoice(MakeOutInvoiceRequest params);

    /**
     * 发票冲红
     */
    Object clearOutInvoice(ClearOutInvoiceRequest params);

    /**
     * 查询发票信息
     *
     * @param fpqqlsh 发票请求流水号
     * @param nsrsbh  纳税人识别号
     */
    InvoiceResult queryInvoiceInfo(String fpqqlsh, String nsrsbh);

    /**
     * 设置商户联系方式, 获取授权链接前需要设置商户联系信息
     */
    void setMerchantContactInfo(MerchantContactInfo contact);

    /**
     * 获取商户联系方式
     */
    MerchantContactInfo getMerchantContactInfo();

}
