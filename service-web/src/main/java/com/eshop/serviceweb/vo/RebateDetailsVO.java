package com.eshop.serviceweb.vo;

import java.math.BigDecimal;
import java.util.Date;

public class RebateDetailsVO {
	private Integer rebateDetailsId;

    private Integer settleBatchId;

    private Integer settleDetailsId;
    
    private Integer memberId;
    
    private String orderNo;

    private String queueingType;

    private Date queueingTime;

    private BigDecimal rebateAmt;

    private Integer rebateMp;

    private String buCode;

    private String currentUser;

    public Integer getRebateDetailsId() {
        return rebateDetailsId;
    }

    public void setRebateDetailsId(Integer rebateDetailsId) {
        this.rebateDetailsId = rebateDetailsId;
    }

    public Integer getSettleBatchId() {
        return settleBatchId;
    }

    public void setSettleBatchId(Integer settleBatchId) {
        this.settleBatchId = settleBatchId;
    }

    public Integer getSettleDetailsId() {
        return settleDetailsId;
    }

    public void setSettleDetailsId(Integer settleDetailsId) {
        this.settleDetailsId = settleDetailsId;
    }
    
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }
    
    public String getQueueingType() {
        return queueingType;
    }

    public void setQueueingType(String queueingType) {
        this.queueingType = queueingType == null ? null : queueingType.trim();
    }

    public Date getQueueingTime() {
        return queueingTime;
    }

    public void setQueueingTime(Date queueingTime) {
        this.queueingTime = queueingTime;
    }

    public BigDecimal getRebateAmt() {
        return rebateAmt;
    }

    public void setRebateAmt(BigDecimal rebateAmt) {
        this.rebateAmt = rebateAmt;
    }

    public Integer getRebateMp() {
        return rebateMp;
    }

    public void setRebateMp(Integer rebateMp) {
        this.rebateMp = rebateMp;
    }

    public String getBuCode() {
        return buCode;
    }

    public void setBuCode(String buCode) {
        this.buCode = buCode == null ? null : buCode.trim();
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser == null ? null : currentUser.trim();
    }
}
