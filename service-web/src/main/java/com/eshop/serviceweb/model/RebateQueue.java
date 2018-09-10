package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class RebateQueue extends BaseModel {
    private Integer settleDetailsId;

    private Integer rebateSeq;

    private BigDecimal rebateBal;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getSettleDetailsId() {
        return settleDetailsId;
    }

    public void setSettleDetailsId(Integer settleDetailsId) {
        this.settleDetailsId = settleDetailsId;
    }

    public Integer getRebateSeq() {
        return rebateSeq;
    }

    public void setRebateSeq(Integer rebateSeq) {
        this.rebateSeq = rebateSeq;
    }

    public BigDecimal getRebateBal() {
        return rebateBal;
    }

    public void setRebateBal(BigDecimal rebateBal) {
        this.rebateBal = rebateBal;
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