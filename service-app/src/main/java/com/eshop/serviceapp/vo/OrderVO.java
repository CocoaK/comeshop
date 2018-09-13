package com.eshop.serviceapp.vo;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderVO {

    @NotNull
    private Integer memberId;
    @NotNull
    private Integer memberAddressId;
    private String zoneCode;
    @NotNull
    private List<OrderDetailVO> orderDetails;

    private String buCode;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberAddressId() {
        return memberAddressId;
    }

    public void setMemberAddressId(Integer memberAddressId) {
        this.memberAddressId = memberAddressId;
    }

    public List<OrderDetailVO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailVO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getBuCode() {
        return buCode;
    }

    public void setBuCode(String buCode) {
        this.buCode = buCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
}
