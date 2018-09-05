package com.eshop.serviceapp.vo;

import com.eshop.serviceweb.model.Order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVO extends Order {

    private Date beginTime;

    private Date endTime;

    private BigDecimal profitAmt;

    private BigDecimal rebateAmt;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getProfitAmt() {
        return profitAmt;
    }

    public void setProfitAmt(BigDecimal profitAmt) {
        this.profitAmt = profitAmt;
    }

    public BigDecimal getRebateAmt() {
        return rebateAmt;
    }

    public void setRebateAmt(BigDecimal rebateAmt) {
        this.rebateAmt = rebateAmt;
    }
}
