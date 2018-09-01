package com.eshop.serviceweb.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class SettleBatch extends BaseModel {
    private Integer settleBatchId;
    @NotNull
    private Date settleTime;

    private String settleType;

    private String settleZone;

    private String settleBy;

    private BigDecimal profitAmt;

    private BigDecimal profitBal;
    @NotNull
    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    private String beginTime;

    private String endTime;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getSettleBatchId() {
        return settleBatchId;
    }

    public void setSettleBatchId(Integer settleBatchId) {
        this.settleBatchId = settleBatchId;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType == null ? null : settleType.trim();
    }

    public String getSettleZone() {
        return settleZone;
    }

    public void setSettleZone(String settleZone) {
        this.settleZone = settleZone == null ? null : settleZone.trim();
    }

    public String getSettleBy() {
        return settleBy;
    }

    public void setSettleBy(String settleBy) {
        this.settleBy = settleBy == null ? null : settleBy.trim();
    }

    public BigDecimal getProfitAmt() {
        return profitAmt;
    }

    public void setProfitAmt(BigDecimal profitAmt) {
        this.profitAmt = profitAmt;
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