package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class RebateDetails extends BaseModel {
    private Integer rebateDetailsId;

    private Integer settleBatchId;

    private Integer settleDetailsId;

    private String queueingType;

    private Date queueingTime;

    private BigDecimal rebateAmt;

    private Integer rebateMp;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getRebateDetailsId() {
        return rebateDetailsId;
    }

    public void setRebateDetailsId(Integer rebateDetailsId) {
        this.rebateDetailsId = rebateDetailsId;
    }

    public Integer getSettleBatchId() {
        return settleBatchId;
    }

    public void setSettleBatchId(Integer settleBatchId) {
        this.settleBatchId = settleBatchId;
    }

    public Integer getSettleDetailsId() {
        return settleDetailsId;
    }

    public void setSettleDetailsId(Integer settleDetailsId) {
        this.settleDetailsId = settleDetailsId;
    }

    public String getQueueingType() {
        return queueingType;
    }

    public void setQueueingType(String queueingType) {
        this.queueingType = queueingType == null ? null : queueingType.trim();
    }

    public Date getQueueingTime() {
        return queueingTime;
    }

    public void setQueueingTime(Date queueingTime) {
        this.queueingTime = queueingTime;
    }

    public BigDecimal getRebateAmt() {
        return rebateAmt;
    }

    public void setRebateAmt(BigDecimal rebateAmt) {
        this.rebateAmt = rebateAmt;
    }

    public Integer getRebateMp() {
        return rebateMp;
    }

    public void setRebateMp(Integer rebateMp) {
        this.rebateMp = rebateMp;
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