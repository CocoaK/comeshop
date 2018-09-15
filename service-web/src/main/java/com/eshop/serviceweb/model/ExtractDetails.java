package com.eshop.serviceweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class ExtractDetails extends BaseModel {
    private Integer extractDetailsId;

    private Integer settleBatchId;

    private Integer memberId;

    private String memberGradeCode;

    private Integer recommendNo1;

    private BigDecimal recommendExtractAmt1;

    private Integer recommendExtractMp1;

    private Integer recommendNo2;

    private BigDecimal recommendExtractAmt2;

    private Integer recommendExtractMp2;

    private Integer renewExtractNo;

    private BigDecimal renewExtractAmt;

    private Integer renewExtractMp;

    private BigDecimal consumptionAmt1;

    private BigDecimal consumptionExtractAmt1;

    private Integer consumptionExtractMp1;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getExtractDetailsId() {
        return extractDetailsId;
    }

    public void setExtractDetailsId(Integer extractDetailsId) {
        this.extractDetailsId = extractDetailsId;
    }

    public Integer getSettleBatchId() {
        return settleBatchId;
    }

    public void setSettleBatchId(Integer settleBatchId) {
        this.settleBatchId = settleBatchId;
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

    public Integer getRecommendNo1() {
        return recommendNo1;
    }

    public void setRecommendNo1(Integer recommendNo1) {
        this.recommendNo1 = recommendNo1;
    }

    public BigDecimal getRecommendExtractAmt1() {
        return recommendExtractAmt1;
    }

    public void setRecommendExtractAmt1(BigDecimal recommendExtractAmt1) {
        this.recommendExtractAmt1 = recommendExtractAmt1;
    }

    public Integer getRecommendExtractMp1() {
        return recommendExtractMp1;
    }

    public void setRecommendExtractMp1(Integer recommendExtractMp1) {
        this.recommendExtractMp1 = recommendExtractMp1;
    }

    public Integer getRecommendNo2() {
        return recommendNo2;
    }

    public void setRecommendNo2(Integer recommendNo2) {
        this.recommendNo2 = recommendNo2;
    }

    public BigDecimal getRecommendExtractAmt2() {
        return recommendExtractAmt2;
    }

    public void setRecommendExtractAmt2(BigDecimal recommendExtractAmt2) {
        this.recommendExtractAmt2 = recommendExtractAmt2;
    }

    public Integer getRecommendExtractMp2() {
        return recommendExtractMp2;
    }

    public void setRecommendExtractMp2(Integer recommendExtractMp2) {
        this.recommendExtractMp2 = recommendExtractMp2;
    }

    public Integer getRenewExtractNo() {
        return renewExtractNo;
    }

    public void setRenewExtractNo(Integer renewExtractNo) {
        this.renewExtractNo = renewExtractNo;
    }

    public BigDecimal getRenewExtractAmt() {
        return renewExtractAmt;
    }

    public void setRenewExtractAmt(BigDecimal renewExtractAmt) {
        this.renewExtractAmt = renewExtractAmt;
    }

    public Integer getRenewExtractMp() {
        return renewExtractMp;
    }

    public void setRenewExtractMp(Integer renewExtractMp) {
        this.renewExtractMp = renewExtractMp;
    }

    public BigDecimal getConsumptionAmt1() {
        return consumptionAmt1;
    }

    public void setConsumptionAmt1(BigDecimal consumptionAmt1) {
        this.consumptionAmt1 = consumptionAmt1;
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