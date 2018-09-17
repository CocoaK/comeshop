package com.eshop.serviceweb.vo;

import java.util.Date;
import java.util.List;

/**
 * 未汇总数据对象
 */
public class UnSettledVO {

    private String startTime;

    private String endTime;

    private List settles;

    private List orders;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public List getSettles() {
        return settles;
    }

    public void setSettles(List settles) {
        this.settles = settles;
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }
}
