package com.eshop.serviceweb.common;

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
    /** 订单状态：已结算*/
    public static final String ORDER_STATUS_SETTLED= "10";

    /** 分区：充值优惠区*/
    public static final String ZONE_RECHARGE = "A00002";


}
