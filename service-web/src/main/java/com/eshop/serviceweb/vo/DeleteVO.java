package com.eshop.serviceweb.vo;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeleteVO extends KeyVO{

    @NotNull
    private Date lastUpdatedDate;
    @NotNull
    private String lastUpdatedBy;

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
