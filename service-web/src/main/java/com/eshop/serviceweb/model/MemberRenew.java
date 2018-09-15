package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberRenew extends BaseModel {
    private Integer memberRenewId;

    private Integer memberId;

    private String memberGrade;

    private BigDecimal renewAmt;

    private Date renewTime;

    private Integer refMemberId;

    private Boolean isReward;

    private Date rewardTime;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getMemberRenewId() {
        return memberRenewId;
    }

    public void setMemberRenewId(Integer memberRenewId) {
        this.memberRenewId = memberRenewId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(String memberGrade) {
        this.memberGrade = memberGrade == null ? null : memberGrade.trim();
    }

    public BigDecimal getRenewAmt() {
        return renewAmt;
    }

    public void setRenewAmt(BigDecimal renewAmt) {
        this.renewAmt = renewAmt;
    }

    public Date getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Date renewTime) {
        this.renewTime = renewTime;
    }

    public Integer getRefMemberId() {
        return refMemberId;
    }

    public void setRefMemberId(Integer refMemberId) {
        this.refMemberId = refMemberId;
    }

    public Boolean getIsReward() {
        return isReward;
    }

    public void setIsReward(Boolean isReward) {
        this.isReward = isReward;
    }

    public Date getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(Date rewardTime) {
        this.rewardTime = rewardTime;
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