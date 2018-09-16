package com.eshop.serviceapp.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderListVO {

    private Integer orderId;

    private String orderNo;

    private List<OrderDetailGoodsVO> zoneGoods;

    private BigDecimal amount;

    private String zoneCode;

    private String zoneName;

    private String status;

    private Integer memberId;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderDetailGoodsVO> getZoneGoods() {
        return zoneGoods;
    }

    public void setZoneGoods(List<OrderDetailGoodsVO> zoneGoods) {
        this.zoneGoods = zoneGoods;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
