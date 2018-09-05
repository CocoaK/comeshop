package com.eshop.serviceapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberGrade extends BaseModel {
    private String gradeCode;

    private String gradeName;

    private String remarks;

    private Boolean isActive;

    private Date inactiveDate;

    private BigDecimal annualFee;

    private BigDecimal oneTimeRecharge;

    private Integer umbrellaMemberNum;

    private Integer umbrellaAreaNum;

    private BigDecimal refereeMemberAmt;

    private BigDecimal refereeMemberRenewAmt;

    private BigDecimal refereeMakerAmt;

    private Integer directMember;

    private Integer umbrellaLevelMember;

    private Integer umbrellaMember;

    private Integer achievement;

    private Integer project;

    private Integer physicalStore;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode == null ? null : gradeCode.trim();
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public BigDecimal getOneTimeRecharge() {
        return oneTimeRecharge;
    }

    public void setOneTimeRecharge(BigDecimal oneTimeRecharge) {
        this.oneTimeRecharge = oneTimeRecharge;
    }

    public Integer getUmbrellaMemberNum() {
        return umbrellaMemberNum;
    }

    public void setUmbrellaMemberNum(Integer umbrellaMemberNum) {
        this.umbrellaMemberNum = umbrellaMemberNum;
    }

    public Integer getUmbrellaAreaNum() {
        return umbrellaAreaNum;
    }

    public void setUmbrellaAreaNum(Integer umbrellaAreaNum) {
        this.umbrellaAreaNum = umbrellaAreaNum;
    }

    public BigDecimal getRefereeMemberAmt() {
        return refereeMemberAmt;
    }

    public void setRefereeMemberAmt(BigDecimal refereeMemberAmt) {
        this.refereeMemberAmt = refereeMemberAmt;
    }

    public BigDecimal getRefereeMemberRenewAmt() {
        return refereeMemberRenewAmt;
    }

    public void setRefereeMemberRenewAmt(BigDecimal refereeMemberRenewAmt) {
        this.refereeMemberRenewAmt = refereeMemberRenewAmt;
    }

    public BigDecimal getRefereeMakerAmt() {
        return refereeMakerAmt;
    }

    public void setRefereeMakerAmt(BigDecimal refereeMakerAmt) {
        this.refereeMakerAmt = refereeMakerAmt;
    }

    public Integer getDirectMember() {
        return directMember;
    }

    public void setDirectMember(Integer directMember) {
        this.directMember = directMember;
    }

    public Integer getUmbrellaLevelMember() {
        return umbrellaLevelMember;
    }

    public void setUmbrellaLevelMember(Integer umbrellaLevelMember) {
        this.umbrellaLevelMember = umbrellaLevelMember;
    }

    public Integer getUmbrellaMember() {
        return umbrellaMember;
    }

    public void setUmbrellaMember(Integer umbrellaMember) {
        this.umbrellaMember = umbrellaMember;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getPhysicalStore() {
        return physicalStore;
    }

    public void setPhysicalStore(Integer physicalStore) {
        this.physicalStore = physicalStore;
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