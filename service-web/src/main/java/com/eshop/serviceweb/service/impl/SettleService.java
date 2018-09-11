package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.*;
import com.eshop.serviceweb.model.*;
import com.eshop.serviceweb.service.ISettleService;
import com.eshop.serviceweb.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SettleService implements ISettleService {

    @Autowired
    private SettleBatchMapper settleBatchMapper;
    @Autowired
    private SettleDetailsMapper settleDetailsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private RebateDetailsMapper rebateDetailsMapper;
    @Autowired
    private RebateQueueMapper rebateQueueMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> execute(SettleBatch settleBatch){
        if(null != settleBatch && !StringUtils.isEmpty(settleBatch.getCurrentUser())){
            settleBatch.setSettleBy(settleBatch.getCurrentUser());
        }
        SettleBatch newestSettleBatch = settleBatchMapper.getNewestOne(settleBatch);
        ResultEntity<String> re = new ResultEntity<String>();
        settleBatch.setSettleTime(new Date());
        settleBatchMapper.insertActive(settleBatch);

        SettleBatch settle  = settleBatchMapper.getOne(settleBatch.getSettleBatchId());
        OrderVO orderVO = new OrderVO();
        orderVO.setEndTime(settleBatch.getSettleTime());
        orderVO.setStatus(Constants.ORDER_STATUS_RECEIPTED);
        orderVO.setSettleStatus(Constants.ORDER_SETTLE_STATUS_UNSETTLED);
        List<Order> orders = new ArrayList<Order>();
        if(null != settleBatch.getSettleZone() && Constants.ZONE_RECHARGE.equals(settleBatch.getSettleZone())){
            orders = orderMapper.getRechargeOrderList(orderVO);
        }else{
            orders = orderMapper.getSettleOrderList(orderVO);
        }
        for(Order od : orders){
            SettleDetails settleDetails = new SettleDetails();
            settleDetails.setOrderId(od.getOrderId());
            settleDetails.setSettleBatchId(settle.getSettleBatchId());
            settleDetails.setProfitAmt(orderDetailsMapper.getProfitAmtSum(od.getOrderId()));
            settleDetails.setRebateAmt(orderDetailsMapper.getRebateAmtSum(od.getOrderId()));
            settleDetails.setBuCode(od.getBuCode());
            settleDetails.setCurrentUser(settle.getLastUpdatedBy());
            //settleDetails.setRowId("1");
            settleDetailsMapper.insertActive(settleDetails);
            //此处插入返利明细表
            RebateDetails rebateDetails = new RebateDetails();
            rebateDetails.setSettleBatchId(settleBatch.getSettleBatchId());
            rebateDetails.setSettleDetailsId(settleDetails.getSettleDetailsId());
            rebateDetails.setRebateMp(1);
            rebateDetails.setRebateAmt(settleDetails.getRebateAmt());
//            rebateDetails.setQueueingTime();
//            rebateDetails.setQueueingType();
            rebateDetails.setCurrentUser(settleBatch.getCurrentUser());
            rebateDetailsMapper.insertActive(rebateDetails);
            //此处插入返利队列表
            RebateQueue rebateQueue = new RebateQueue();
//            rebateQueue.setRebateBal();
//            rebateQueue.setRebateSeq();
            rebateQueue.setSettleDetailsId(settleDetails.getSettleDetailsId());
            rebateQueue.setCurrentUser(settleBatch.getCurrentUser());
            rebateQueueMapper.insertActive(rebateQueue);
            //od.setStatus(Constants.ORDER_SETTLE_STATUS_SETTLED);
            od.setSettleStatus(Constants.ORDER_SETTLE_STATUS_SETTLED);
            orderMapper.updateActive(od);
        }
        settle.setProfitAmt(settleDetailsMapper.getProfitAmtSum(settle.getSettleBatchId()));
        BigDecimal rebateAmount = newestSettleBatch.getProfitBal().add(settleDetailsMapper.getRebateAmtSum(settle.getSettleBatchId()));
        settle.setProfitBal(rebateAmount);
        settleBatchMapper.updateActive(settle);
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg(ResultEntity.MSG_SUCCESS);
        return re;
    }

}
