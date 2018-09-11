package com.eshop.serviceapp.vo;

import java.io.Serializable;

public class MemberVO implements Serializable {

    private String userName;

    private String password;

    private String telephone;

    private String refMemberUser;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRefMemberUser() {
        return refMemberUser;
    }

    public void setRefMemberUser(String refMemberUser) {
        this.refMemberUser = refMemberUser;
    }
}
