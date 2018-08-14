package com.eshop.serviceweb.common.util;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**首字母大写*/
    public static String captureName(String name){
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    /*  一、假定密码字符数范围6-16，除英文数字和字母外的字符都视为特殊字符：
    弱：^[0-9A-Za-z]{6,16}$
    中：^(?=.{6,16})[0-9A-Za-z]*[^0-9A-Za-z][0-9A-Za-z]*$
    强：^(?=.{6,16})([0-9A-Za-z]*[^0-9A-Za-z][0-9A-Za-z]*){2,}$
    二、假定密码字符数范围6-16，密码字符允许范围为ASCII码表字符：
    弱：^[0-9A-Za-z]{6,16}$
    中：^(?=.{6,16})[0-9A-Za-z]*[\x00-\x2f\x3A-\x40\x5B-\xFF][0-9A-Za-z]*$
    强：^(?=.{6,16})([0-9A-Za-z]*[\x00-\x2F\x3A-\x40\x5B-\xFF][0-9A-Za-z]*){2,}$

    String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$"
    描述：(?![0-9]+$) 预测该位置后面不全是数字
          (?![a-zA-Z]+$) 预测该位置后面不全是字母
          [0-9A-Za-z] {8,16} 由8-16位数字或这字母组成
    */
    public static String checkPassword(String passwordStr) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        String regexZ = "\\d*";
        String regexS = "[a-zA-Z]+";
        String regexT = "\\W+$";
        String regexZT = "\\D*";
        String regexST = "[\\d\\W]*";
        String regexZS = "\\w*";
        String regexZST = "[\\w\\W]*";
        if(!passwordStr.matches(regex)){
            return "密码须同时包含数字与字母";
        }
        if (passwordStr.matches(regexZ)) {
            return "弱";
        }
        if (passwordStr.matches(regexS)) {
            return "弱";
        }
        if (passwordStr.matches(regexT)) {
            return "弱";
        }
        if (passwordStr.matches(regexZT)) {
            return "中";
        }
        if (passwordStr.matches(regexST)) {
            return "中";
        }
        if (passwordStr.matches(regexZS)) {
            return "中";
        }
        if (passwordStr.matches(regexZST)) {
            return "强";
        }
        return passwordStr;
    }
}
