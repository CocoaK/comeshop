package com.eshop.serviceweb.model;

import java.util.Date;

public class MemberRebate extends BaseModel {
    private Integer rebateId;

    private Integer memberId;

    private Integer rebate;

    private Integer rebateCycle;

    private Integer rebateRatio;

    private Integer maxOrderNum;

    private Integer rebateRatioEach;

    private Integer discount;

    private Boolean isActive;

    private Date inactiveDate;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getRebateId() {
        return rebateId;
    }

    public void setRebateId(Integer rebateId) {
        this.rebateId = rebateId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getRebate() {
        return rebate;
    }

    public void setRebate(Integer rebate) {
        this.rebate = rebate;
    }

    public Integer getRebateCycle() {
        return rebateCycle;
    }

    public void setRebateCycle(Integer rebateCycle) {
        this.rebateCycle = rebateCycle;
    }

    public Integer getRebateRatio() {
        return rebateRatio;
    }

    public void setRebateRatio(Integer rebateRatio) {
        this.rebateRatio = rebateRatio;
    }

    public Integer getMaxOrderNum() {
        return maxOrderNum;
    }

    public void setMaxOrderNum(Integer maxOrderNum) {
        this.maxOrderNum = maxOrderNum;
    }

    public Integer getRebateRatioEach() {
        return rebateRatioEach;
    }

    public void setRebateRatioEach(Integer rebateRatioEach) {
        this.rebateRatioEach = rebateRatioEach;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
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