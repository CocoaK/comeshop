package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class SettleReward extends BaseModel {
    private Integer settleRewardId;

    private Integer memberId;

    private String memberGradeCode;

    private Integer renewExtractNo1;

    private Integer renewExtractMp1;

    private Integer renewExtractNo2;

    private Integer renewExtractMp2;

    private BigDecimal consumptionExtractAmt1;

    private Integer consumptionExtractMp1;

    private BigDecimal consumptionExtractAmt2;

    private Integer consumptionExtractMp2;

    private BigDecimal consumptionExtractAmt3;

    private Integer consumptionExtractMp3;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getSettleRewardId() {
        return settleRewardId;
    }

    public void setSettleRewardId(Integer settleRewardId) {
        this.settleRewardId = settleRewardId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberGradeCode() {
        return memberGradeCode;
    }

    public void setMemberGradeCode(String memberGradeCode) {
        this.memberGradeCode = memberGradeCode == null ? null : memberGradeCode.trim();
    }

    public Integer getRenewExtractNo1() {
        return renewExtractNo1;
    }

    public void setRenewExtractNo1(Integer renewExtractNo1) {
        this.renewExtractNo1 = renewExtractNo1;
    }

    public Integer getRenewExtractMp1() {
        return renewExtractMp1;
    }

    public void setRenewExtractMp1(Integer renewExtractMp1) {
        this.renewExtractMp1 = renewExtractMp1;
    }

    public Integer getRenewExtractNo2() {
        return renewExtractNo2;
    }

    public void setRenewExtractNo2(Integer renewExtractNo2) {
        this.renewExtractNo2 = renewExtractNo2;
    }

    public Integer getRenewExtractMp2() {
        return renewExtractMp2;
    }

    public void setRenewExtractMp2(Integer renewExtractMp2) {
        this.renewExtractMp2 = renewExtractMp2;
    }

    public BigDecimal getConsumptionExtractAmt1() {
        return consumptionExtractAmt1;
    }

    public void setConsumptionExtractAmt1(BigDecimal consumptionExtractAmt1) {
        this.consumptionExtractAmt1 = consumptionExtractAmt1;
    }

    public Integer getConsumptionExtractMp1() {
        return consumptionExtractMp1;
    }

    public void setConsumptionExtractMp1(Integer consumptionExtractMp1) {
        this.consumptionExtractMp1 = consumptionExtractMp1;
    }

    public BigDecimal getConsumptionExtractAmt2() {
        return consumptionExtractAmt2;
    }

    public void setConsumptionExtractAmt2(BigDecimal consumptionExtractAmt2) {
        this.consumptionExtractAmt2 = consumptionExtractAmt2;
    }

    public Integer getConsumptionExtractMp2() {
        return consumptionExtractMp2;
    }

    public void setConsumptionExtractMp2(Integer consumptionExtractMp2) {
        this.consumptionExtractMp2 = consumptionExtractMp2;
    }

    public BigDecimal getConsumptionExtractAmt3() {
        return consumptionExtractAmt3;
    }

    public void setConsumptionExtractAmt3(BigDecimal consumptionExtractAmt3) {
        this.consumptionExtractAmt3 = consumptionExtractAmt3;
    }

    public Integer getConsumptionExtractMp3() {
        return consumptionExtractMp3;
    }

    public void setConsumptionExtractMp3(Integer consumptionExtractMp3) {
        this.consumptionExtractMp3 = consumptionExtractMp3;
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