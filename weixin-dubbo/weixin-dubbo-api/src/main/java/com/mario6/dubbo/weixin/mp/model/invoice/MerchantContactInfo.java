package com.mario6.dubbo.weixin.mp.model.invoice;

import lombok.Data;

import java.io.Serializable;

/**
 * 设置商户联系信息和发票过时时间参数
 */

@Data
public class MerchantContactInfo implements Serializable {

    private Contact contact;


    public static class Contact implements Serializable {
        /**
         * 联系电话
         */
        private String phone;

        /**
         * 开票超时时间
         */
        private Integer timeout;

    }

}
