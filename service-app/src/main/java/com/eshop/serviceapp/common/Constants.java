package com.eshop.serviceapp.common;

/**
 * 常量类
 */
public class Constants {

    /**jwt token 过期时间:单位秒*/
    public static final int JWT_TOKEN_EXPIRE_TIME = 3600 * 24 * 10;
    /**redis token 过期时间:单位秒*/
    public static final int REDIS_TOKEN_EXPIRE_TIME = 60000;
    /** accessToken*/
    public static final String ACCESS_TOKEN = "token";
    /** 订单状态：已取消*/
    public static final String ORDER_STATUS_CANCEL = "0";
    /** 订单状态：待支付*/
    public static final String ORDER_STATUS_UNPAID = "1";
    /** 订单状态：已支付*/
    public static final String ORDER_STATUS_PAID = "2";
    /** 订单状态：已发货*/
    public static final String ORDER_STATUS_SHIPPED= "3";
    /** 订单状态：已收货*/
    public static final String ORDER_STATUS_RECEIPTED = "4";
    /** 订单状态：已评价*/
    public static final String ORDER_STATUS_APPRAISED= "5";
    /** 订单状态：退货*/
    public static final String ORDER_STATUS_RETURNED = "6";
    /** 订单结算状态：未结算*/
    public static final String ORDER_SETTLE_STATUS_UNSETTLED= "0";
    /** 订单结算状态：已结算*/
    public static final String ORDER_SETTLE_STATUS_SETTLED= "1";

    /** 分区：充值优惠区*/
    public static final String ZONE_RECHARGE = "Z00002";
    /** 商品媒体类型：图片*/
    public static final String GOODS_MEDIA_TYPE_IMAGE= "IMAGE";
    /** 商品媒体类型：图片*/
    public static final String GOODS_MEDIA_TYPE_VIDEO = "VIDEO";

    /** 会员体现状态：待审核*/
    public static final String MEMBER_EXCHANGE_STATUS_PENDING = "0";
    /** 会员体现状态：已批准*/
    public static final String MEMBER_EXCHANGE_STATUS_APPROVED = "1";
    /** 会员体现状态：已拒绝*/
    public static final String MEMBER_EXCHANGE_STATUS_REJECTED = "2";
    /** 会员体现状态：待转账*/
    public static final String MEMBER_EXCHANGE_STATUS_NOT_TRANSFERRED = "3";
    /** 会员体现状态：已转账*/
    public static final String MEMBER_EXCHANGE_STATUS_TRANSFERRED = "4";

    /** 企业代码*/
    public static final String BU_CODE = "ESHOP";

    /** 账户类型：微信*/
    public static final String ACCOUNT_TYPE_WECHAT = "wechat";
    /** 账户类型：支付宝*/
    public static final String ACCOUNT_TYPE_ALIPAY = "alipay";
    /** 账户类型：银行账户*/
    public static final String ACCOUNT_TYPE_BANK = "bank";

}
