package com.eshop.serviceapp.vo;

import com.eshop.serviceapp.model.Member;

public class LoginResultVO {
    private String token;

    private Member member;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
