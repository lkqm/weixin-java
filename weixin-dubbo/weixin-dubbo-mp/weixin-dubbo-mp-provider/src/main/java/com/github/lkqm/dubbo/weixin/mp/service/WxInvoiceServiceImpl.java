package com.github.lkqm.dubbo.weixin.mp.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.lkqm.dubbo.weixin.mp.model.invoice.*;
import com.github.lkqm.dubbo.weixin.mp.util.WxMpExceptionUtils;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.enums.TicketType;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

import java.util.HashMap;
import java.util.Map;

import static com.github.lkqm.dubbo.weixin.mp.util.WxHandlerUtils.handle;


@Service
@AllArgsConstructor
public class WxInvoiceServiceImpl implements WxInvoiceService {

    private WxMpService wxMpService;

    private static final String WX_URL = "https://api.weixin.qq.com";
    private static final String INVOICE_URL = WX_URL + "/card/invoice";

    @Override
    public InvoiceAuthPageResult getAuthPageUrl(InvoiceAuthPageRequest params) {
        String url = getWxInvoiceFullUrl("/getauthurl");
        String ticket = handle(() -> wxMpService.getTicket(TicketType.WX_CARD));
        params.setTicket(ticket);
        return doCommonInvoiceHttpPost(url, params, InvoiceAuthPageResult.class);
    }

    @Override
    public InvoiceAuthDataResult getAuthData(InvoiceAuthDataRequest params) {
        String url = getWxInvoiceFullUrl("/getauthdata");
        return doCommonInvoiceHttpPost(url, params, InvoiceAuthDataResult.class);
    }

    @Override
    public void rejectInvoice(InvoiceRejectRequest params) {
        String url = getWxInvoiceFullUrl("/rejectinsert");
        doCommonInvoiceHttpPost(url, params, null);
    }

    @Override
    public void makeOutInvoice(MakeOutInvoiceRequest params) {
        String url = getWxInvoiceFullUrl("/makeoutinvoice");
        doCommonInvoiceHttpPost(url, params, null);
    }

    @Override
    public Object clearOutInvoice(ClearOutInvoiceRequest params) {
        String url = getWxInvoiceFullUrl("/clearoutinvoice");
        return doCommonInvoiceHttpPost(url, params, Object.class);
    }

    @Override
    public InvoiceResult queryInvoiceInfo(String fpqqlsh, String nsrsbh) {
        String url = getWxInvoiceFullUrl("/queryinvoceinfo");
        Map data = new HashMap();
        data.put("fpqqlsh", fpqqlsh);
        data.put("nsrsbh", nsrsbh);
        return doCommonInvoiceHttpPost(url, data, InvoiceResult.class);
    }

    @Override
    public void setMerchantContactInfo(MerchantContactInfo contact) {
        String url = getWxInvoiceFullUrl("/setbizattr?action=set_contact");
        doCommonInvoiceHttpPost(url, contact, null);
    }

    @Override
    public MerchantContactInfo getMerchantContactInfo() {
        String url = getWxInvoiceFullUrl("/setbizattr?action=get_contact");
        return doCommonInvoiceHttpPost(url, null, MerchantContactInfo.class);
    }

    private String getWxInvoiceFullUrl(String subUri) {
        return INVOICE_URL + subUri;
    }

    /**
     * 电子发票公用post请求方法
     */
    private <T> T doCommonInvoiceHttpPost(String url, Object data, Class<T> resultClass) {
        try {
            String json = "";
            if (data != null) {
                json = WxMpGsonBuilder.create().toJson(data);
            }

            String responseText = wxMpService.post(url, json);
            if (resultClass == null) return null;

            return WxMpGsonBuilder.create().fromJson(responseText, resultClass);
        } catch (WxErrorException e) {
            throw WxMpExceptionUtils.newWxException(e);
        }
    }
}
