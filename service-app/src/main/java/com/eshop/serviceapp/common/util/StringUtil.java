package com.eshop.serviceapp.common.util;

public class StringUtil {

    /**首字母大写*/
    public static String captureName(String name){
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }
}
