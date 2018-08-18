package com.eshop.serviceweb.vo;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeleteVO {
    @NotNull
    private Integer id;
    @NotNull
    private Date lastUpdatedDate;
    @NotNull
    private String lastUpdatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
