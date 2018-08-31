package com.eshop.serviceweb.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class Order extends BaseModel {
    private Integer orderId;

    private String orderCode;
    @NotNull
    private Integer memberId;
    @NotNull
    private Integer memberAddressId;
    @NotNull
    private BigDecimal totalPrice;
    @NotNull
    private BigDecimal totalDiscountAmt;
    @NotNull
    private BigDecimal totalProfitAmt;
    @NotNull
    private BigDecimal totalRebateAmt;
    @NotNull
    private Integer arMp;
    @NotNull
    private Integer apMp;

    private Date paymentTime;
    @NotNull
    private String status;
    @NotNull
    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;
    @NotNull
    private String rowId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalDiscountAmt() {
        return totalDiscountAmt;
    }

    public void setTotalDiscountAmt(BigDecimal totalDiscountAmt) {
        this.totalDiscountAmt = totalDiscountAmt;
    }

    public BigDecimal getTotalProfitAmt() {
        return totalProfitAmt;
    }

    public void setTotalProfitAmt(BigDecimal totalProfitAmt) {
        this.totalProfitAmt = totalProfitAmt;
    }

    public BigDecimal getTotalRebateAmt() {
        return totalRebateAmt;
    }

    public void setTotalRebateAmt(BigDecimal totalRebateAmt) {
        this.totalRebateAmt = totalRebateAmt;
    }

    public Integer getArMp() {
        return arMp;
    }

    public void setArMp(Integer arMp) {
        this.arMp = arMp;
    }

    public Integer getApMp() {
        return apMp;
    }

    public void setApMp(Integer apMp) {
        this.apMp = apMp;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBuCode() {
        return buCode;
    }

    public void setBuCode(String buCode) {
        this.buCode = buCode == null ? null : buCode.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId == null ? null : rowId.trim();
    }
}