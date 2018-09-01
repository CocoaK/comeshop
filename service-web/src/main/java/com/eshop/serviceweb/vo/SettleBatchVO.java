package com.eshop.serviceweb.vo;

import com.eshop.serviceweb.model.SettleBatch;

import java.math.BigDecimal;

public class SettleBatchVO extends SettleBatch {

    private Integer orderCount;

    private BigDecimal orderAmount;
    
    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
