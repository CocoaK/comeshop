package com.eshop.serviceweb.common;

/**
 * 常量类
 */
public class Constants {

    /**jwt token 过期时间:单位秒*/
    public static final int JWT_TOKEN_EXPIRE_TIME = 3600 * 24 * 10;
    /**redis token 过期时间:单位秒*/
    public static final int REDIS_TOKEN_EXPIRE_TIME = 6000;
    /** accessToken*/
    public static final String ACCESS_TOKEN = "token";
}
