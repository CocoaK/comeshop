package com.eshop.serviceapp.model;

import java.util.Date;

public class MemberGradeHist extends BaseModel {
    private Integer memberGradeHistId;

    private Integer memberId;

    private Date eventDate;

    private String eventType;

    private String eventBy;

    private String gradeBefore;

    private String gradeAfter;

    private String buCode;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getMemberGradeHistId() {
        return memberGradeHistId;
    }

    public void setMemberGradeHistId(Integer memberGradeHistId) {
        this.memberGradeHistId = memberGradeHistId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public String getEventBy() {
        return eventBy;
    }

    public void setEventBy(String eventBy) {
        this.eventBy = eventBy == null ? null : eventBy.trim();
    }

    public String getGradeBefore() {
        return gradeBefore;
    }

    public void setGradeBefore(String gradeBefore) {
        this.gradeBefore = gradeBefore == null ? null : gradeBefore.trim();
    }

    public String getGradeAfter() {
        return gradeAfter;
    }

    public void setGradeAfter(String gradeAfter) {
        this.gradeAfter = gradeAfter == null ? null : gradeAfter.trim();
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