package com.eshop.serviceapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class ZoneGoods extends BaseModel {
    private Integer zoneGoodsId;

    private String zoneCode;

    private Integer goodsId;

    private Integer goodsModelId;

    private String status;

    private Integer goodsQty;

    private BigDecimal discountAmt;

    private BigDecimal profitAmt;

    private BigDecimal rebateAmt;

    private Boolean isDefault;

    private Boolean isShowInHome;

    private Integer dispSeq;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getZoneGoodsId() {
        return zoneGoodsId;
    }

    public void setZoneGoodsId(Integer zoneGoodsId) {
        this.zoneGoodsId = zoneGoodsId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode == null ? null : zoneCode.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsModelId() {
        return goodsModelId;
    }

    public void setGoodsModelId(Integer goodsModelId) {
        this.goodsModelId = goodsModelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getGoodsQty() {
        return goodsQty;
    }

    public void setGoodsQty(Integer goodsQty) {
        this.goodsQty = goodsQty;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getProfitAmt() {
        return profitAmt;
    }

    public void setProfitAmt(BigDecimal profitAmt) {
        this.profitAmt = profitAmt;
    }

    public BigDecimal getRebateAmt() {
        return rebateAmt;
    }

    public void setRebateAmt(BigDecimal rebateAmt) {
        this.rebateAmt = rebateAmt;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsShowInHome() {
        return isShowInHome;
    }

    public void setIsShowInHome(Boolean isShowInHome) {
        this.isShowInHome = isShowInHome;
    }

    public Integer getDispSeq() {
        return dispSeq;
    }

    public void setDispSeq(Integer dispSeq) {
        this.dispSeq = dispSeq;
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