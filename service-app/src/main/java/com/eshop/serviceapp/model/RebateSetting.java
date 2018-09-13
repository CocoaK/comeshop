package com.eshop.serviceapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class RebateSetting extends BaseModel {
    private Integer rebateSettingId;

    private Integer dailyRebateOrders;

    private Integer exchangeRate;

    private BigDecimal profitBal;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getRebateSettingId() {
        return rebateSettingId;
    }

    public void setRebateSettingId(Integer rebateSettingId) {
        this.rebateSettingId = rebateSettingId;
    }

    public Integer getDailyRebateOrders() {
        return dailyRebateOrders;
    }

    public void setDailyRebateOrders(Integer dailyRebateOrders) {
        this.dailyRebateOrders = dailyRebateOrders;
    }

    public Integer getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getProfitBal() {
        return profitBal;
    }

    public void setProfitBal(BigDecimal profitBal) {
        this.profitBal = profitBal;
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