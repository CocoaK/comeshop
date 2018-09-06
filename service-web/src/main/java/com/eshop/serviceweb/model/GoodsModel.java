package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsModel extends BaseModel {
    private Integer goodsModelId;

    private Integer goodsId;

    private String goodsModelName;

    private BigDecimal price;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getGoodsModelId() {
        return goodsModelId;
    }

    public void setGoodsModelId(Integer goodsModelId) {
        this.goodsModelId = goodsModelId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsModelName() {
        return goodsModelName;
    }

    public void setGoodsModelName(String goodsModelName) {
        this.goodsModelName = goodsModelName == null ? null : goodsModelName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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