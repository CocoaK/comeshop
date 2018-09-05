package com.eshop.serviceapp.model;

import java.util.Date;

public class MemberBpHistory extends BaseModel {
    private Integer integrationId;

    private Integer memberId;

    private Integer integration;

    private Integer preIntegration;

    private Integer afterIntegration;

    private Date eventTime;

    private String eventType;

    private String eventBy;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String rowId;

    public Integer getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(Integer integrationId) {
        this.integrationId = integrationId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getPreIntegration() {
        return preIntegration;
    }

    public void setPreIntegration(Integer preIntegration) {
        this.preIntegration = preIntegration;
    }

    public Integer getAfterIntegration() {
        return afterIntegration;
    }

    public void setAfterIntegration(Integer afterIntegration) {
        this.afterIntegration = afterIntegration;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
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