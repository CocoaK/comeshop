package com.eshop.serviceweb.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class RoleFunc extends BaseModel {
    @NotNull
    private Integer roleId;
    @NotNull
    private String funcCode;

    private Boolean isAllowInd;
    @NotNull
    private String createdBy;
    @NotNull
    private Date createdDate;
    @NotNull
    private String lastUpdatedBy;
    @NotNull
    private Date lastUpdatedDate;
    @NotNull
    private String rowId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
    }

    public Boolean getIsAllowInd() {
        return isAllowInd;
    }

    public void setIsAllowInd(Boolean isAllowInd) {
        this.isAllowInd = isAllowInd;
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