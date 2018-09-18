package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
//import com.eshop.serviceweb.common.util.UUIDUtil;
import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.mapper.*;
import com.eshop.serviceweb.model.*;
import com.eshop.serviceweb.service.ISettleService;
import com.eshop.serviceweb.vo.OrderVO;
import com.eshop.serviceweb.vo.PageVO;
import com.eshop.serviceweb.vo.RebateDetailsVO;

import com.eshop.serviceweb.vo.UnSettledVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    private MemberMapper memberMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private RebateDetailsMapper rebateDetailsMapper;
    @Autowired
    private RebateQueueMapper rebateQueueMapper;
    @Autowired
    private RebateSettingMapper rebateSettingMapper;
    @Autowired
    private MemberMpDetailsMapper memberMpDetailsMapper;
    @Autowired
    private ZoneMapper zoneMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity<String> execute(SettleBatch settleBatch){
        ResultEntity<String> re = new ResultEntity<String>();
        if(null != settleBatch && !StringUtils.isEmpty(settleBatch.getCurrentUser())){
            settleBatch.setSettleBy(settleBatch.getCurrentUser());
        }
        if(null != settleBatch && StringUtils.isEmpty(settleBatch.getSettleType())){
            settleBatch.setSettleType("SETTLE");
        }
        try {
            Date d=new Date();
            //体验区结算
            SettleBatch sb1 = new SettleBatch();
            sb1.setSettleType(settleBatch.getSettleType());
            sb1.setSettleBy(settleBatch.getSettleBy());
            sb1.setBuCode(settleBatch.getBuCode());
            sb1.setSettleZone(Constants.ZONE_TYPE_EXPERIENCE);
            sb1.setSettleTime(d);
            sb1.setCurrentUser(settleBatch.getCurrentUser());
            settle(sb1);
            //普通区结算
            SettleBatch sb2 = new SettleBatch();
            sb2.setSettleType(settleBatch.getSettleType());
            sb2.setSettleBy(settleBatch.getSettleBy());
            sb2.setBuCode(settleBatch.getBuCode());
            sb2.setSettleZone(Constants.ZONE_TYPE_COMMON);
            sb2.setSettleTime(d);
            sb2.setCurrentUser(settleBatch.getCurrentUser());
            settle(sb2);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg(ResultEntity.MSG_SUCCESS);
        return re;
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResultEntity<String> executeRebate(List<RebateDetailsVO> rebateDetailsVOList){
    	Date dateNow = new Date();
    	BigDecimal AllrebateAmt=new BigDecimal("0.00");
    	String currentUser="";
    	
        ResultEntity<String> re = new ResultEntity<String>();
        for(RebateDetailsVO vo : rebateDetailsVOList){
        	currentUser=vo.getCurrentUser();
            AllrebateAmt=AllrebateAmt.add(vo.getRebateAmt());
        	
        	RebateDetails rebateDetails = new RebateDetails();
        	rebateDetails.setSettleBatchId(vo.getSettleBatchId());
        	rebateDetails.setSettleDetailsId(vo.getSettleDetailsId());
        	
        	rebateDetails.setQueueingType(vo.getQueueingType());
        	rebateDetails.setQueueingTime(vo.getQueueingTime());
        	rebateDetails.setRebateAmt(vo.getRebateAmt());
        	Integer rebateAmt=Integer.parseInt(vo.getRebateAmt().toString())*1;//注意
        	rebateDetails.setRebateMp(rebateAmt);
        	rebateDetails.setBuCode("ESHOP");
        	//rebateDetails.setRowId(UUIDUtil.getUUID());
//        	rebateDetails.setCreatedBy(vo.getCurrentUser());
//        	rebateDetails.setCreatedDate(dateNow);
//        	rebateDetails.setLastUpdatedBy(vo.getCurrentUser());
//        	rebateDetails.setLastUpdatedDate(dateNow);
            rebateDetails.setCurrentUser(vo.getCurrentUser());
        	rebateDetailsMapper.insertActive(rebateDetails);
        	
        	//更新会员积分
        	Member memberCheck=memberMapper.getOne(vo.getMemberId());
        	
        	//写会员积分记录
        	MemberMpDetails mm=new MemberMpDetails();
        	mm.setMemberId(vo.getMemberId());
        	mm.setRefNo(vo.getOrderNo());
        	mm.setMpAmt(rebateAmt);
        	mm.setMpBal(memberCheck.getMpAmt()+rebateAmt);
        	mm.setEventTime(dateNow);
        	mm.setEventType("2");
        	mm.setEventBy(vo.getCurrentUser());
        	//mm.setEffectiveDate()
        	mm.setBuCode("ESHOP");
//        	mm.setRowId(UUIDUtil.getUUID());
            mm.setCurrentUser(vo.getCurrentUser());
//            mm.setCreatedBy(vo.getCurrentUser());
//        	mm.setCreatedDate(dateNow);
//        	mm.setLastUpdatedBy(vo.getCurrentUser());
//        	mm.setLastUpdatedDate(dateNow);
        	memberMpDetailsMapper.insertActive(mm);
        	
        	Member memberModel=new Member();
        	memberModel.setMemberId(vo.getMemberId());
        	memberModel.setMpAmt(memberCheck.getMpAmt()+rebateAmt);
//        	memberModel.setLastUpdatedBy(vo.getCurrentUser());
//        	memberModel.setLastUpdatedDate(dateNow);
            memberModel.setCurrentUser(vo.getCurrentUser());
        	memberMapper.updateActive(memberModel);
        	
        	//所有返利金额是否全部返完
        	RebateQueue rq = rebateQueueMapper.getOne(vo.getSettleDetailsId());
        	int intResult = rq.getRebateBal().compareTo(vo.getRebateAmt());
        			
        	if(intResult==1) {
        		RebateQueue rqModel=new RebateQueue();
        		//更新
        		rqModel.setSettleDetailsId(vo.getSettleDetailsId());
        		rqModel.setRebateBal(rq.getRebateBal().subtract(vo.getRebateAmt()));
                rqModel.setCurrentUser(vo.getCurrentUser());
//                rqModel.setLastUpdatedBy(vo.getCurrentUser());
//                rqModel.setLastUpdatedDate(dateNow);
            	
        		rebateQueueMapper.updateActive(rqModel);
        	}
        	else if(intResult==0) {
        		//删除
        		rebateQueueMapper.delete(vo.getSettleDetailsId());
        	}
        	else
        	{
        		//报错了
                re.setCode(ResultEntity.FAILD);
                re.setMsg("返利数据有误");
                return re;
        	}
        	
        	
        }
        //更新余额池
        RebateSetting rs=rebateSettingMapper.getOne(1);
        RebateSetting rsModel=new RebateSetting();
        rsModel.setRebateSettingId(rs.getRebateSettingId());
        rsModel.setProfitBal(rs.getProfitBal().subtract(AllrebateAmt));
//        rsModel.setLastUpdatedBy(currentUser);
//        rsModel.setLastUpdatedDate(dateNow);
        rsModel.setCurrentUser(currentUser);
        rebateSettingMapper.updateActive(rsModel);
        
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg(ResultEntity.MSG_SUCCESS);
        return re;
    }

    /**
     * 结算的方法
     * @param settleBatch
     */
    @Transactional(propagation = Propagation.REQUIRED)
    private void settle(SettleBatch settleBatch){
        if(null != settleBatch && !StringUtils.isEmpty(settleBatch.getCurrentUser())){
            settleBatch.setSettleBy(settleBatch.getCurrentUser());
        }
        SettleBatch settleBatchTemp = new SettleBatch();
//        settleBatchTemp.setSettleType("SETTLE");
        settleBatchTemp.setSettleZone(settleBatch.getSettleZone());
        //最新结算
        SettleBatch newestSettleBatch = settleBatchMapper.getNewestOne(settleBatchTemp);
        ResultEntity<String> re = new ResultEntity<String>();
        settleBatch.setSettleTime(new Date());
        settleBatchMapper.insertActive(settleBatch);
        //返利设置
        RebateSetting rebateSetting = rebateSettingMapper.getAll().get(0);
        SettleBatch settle  = settleBatchMapper.get(settleBatch.getSettleBatchId());
        OrderVO orderVO = new OrderVO();
        orderVO.setEndTime(settleBatch.getSettleTime());
        orderVO.setSettleStatus(Constants.ORDER_SETTLE_STATUS_UNSETTLED);
        List<Order> orders = orderMapper.getSettleOrderList(orderVO);
        List<Zone> zoneList = zoneMapper.getAll();
        List<Order> curOrderList = new ArrayList<Order>();
        if(orders !=null && orders.isEmpty()){
            for(Order order : orders){
                for(Zone zone : zoneList){
                    //如果是指定区的订单
                    if(settleBatch.getSettleZone().equals(zone.getZoneType()) && order.getZoneCode().equals(zone.getZoneCode())){
                        curOrderList.add(order);
                    }
                }

            }
        }
//        if(null != settleBatch.getSettleZone() && Constants.ZONE_TYPE_EXPERIENCE.equals(settleBatch.getSettleZone())){
//            orders = orderMapper.getRechargeOrderList(orderVO);
//        }else{
//            orders = orderMapper.getSettleOrderList(orderVO);
//        }
        //订单序数
        int index = 0;
        for(Order od : curOrderList){
            index ++;
            SettleDetails settleDetails = new SettleDetails();
            settleDetails.setOrderId(od.getOrderId());
            settleDetails.setSettleBatchId(settle.getSettleBatchId());
            settleDetails.setProfitAmt(orderDetailsMapper.getProfitAmtSum(od.getOrderId()));
            settleDetails.setRebateAmt(orderDetailsMapper.getRebateAmtSum(od.getOrderId()));
            settleDetails.setBuCode(od.getBuCode());
            settleDetails.setCurrentUser(settle.getLastUpdatedBy());
            settleDetailsMapper.insertActive(settleDetails);
            //当订单序数小于返利队列表每日返利订单数时，插入返利队列
            if(index<=rebateSetting.getDailyRebateOrders()){
                RebateQueue rebateQueue = new RebateQueue();
                rebateQueue.setBuCode(settleBatch.getBuCode());
                rebateQueue.setRebateBal(settleDetails.getRebateAmt());
                rebateQueue.setRebateSeq(rebateQueueMapper.getMaxRebateSeq()+1);//数据库中最大的+1
                rebateQueue.setSettleDetailsId(settleDetails.getSettleDetailsId());
                rebateQueue.setCurrentUser(settleBatch.getCurrentUser());
                rebateQueueMapper.insertActive(rebateQueue);
            }
            od.setSettleStatus(Constants.ORDER_SETTLE_STATUS_SETTLED);
            orderMapper.updateActive(od);
        }
        BigDecimal profitAmtSum = settleDetailsMapper.getProfitAmtSum(settle.getSettleBatchId());
        if(profitAmtSum==null){
            profitAmtSum = new BigDecimal(0);
        }
        settle.setProfitAmt(profitAmtSum);
        BigDecimal rebateAmount = settleDetailsMapper.getRebateAmtSum(settle.getSettleBatchId());
        if(rebateAmount == null){
            rebateAmount = new BigDecimal(0);
        }
        if(newestSettleBatch!=null){
            rebateAmount = newestSettleBatch.getProfitBal().add(rebateAmount);
        }
        settle.setProfitBal(rebateAmount);
        settleBatchMapper.updateActive(settle);
        //结算后将返利设置的返利池更新
        rebateSetting.setProfitBal(rebateAmount);
        rebateSettingMapper.updateActive(rebateSetting);
    }

    @Override
    public ResultEntity queryList(SettleBatch settleBatch){
        ResultEntity<UnSettledVO> re = new ResultEntity<UnSettledVO>();
        UnSettledVO unSettledVO = new UnSettledVO();
        SettleBatch settleBatch1 = new SettleBatch();
        settleBatch.setSettleZone(Constants.ZONE_TYPE_COMMON);
        SettleBatch newestSettleBatch = settleBatchMapper.getNewestOne(settleBatch);
        unSettledVO.setStartTime(newestSettleBatch.getBeginTime());
        unSettledVO.setEndTime(settleBatch.getEndTime());
        unSettledVO.setOrders(orderMapper.getUnSettleOrderList(settleBatch));
        unSettledVO.setSettles(orderMapper.getUnSettleOrderSumList(settleBatch));
        re.setCode(ResultEntity.SUCCESS);
        re.setMsg(ResultEntity.MSG_SUCCESS);
        re.setData(unSettledVO);
        return re;
    }

    @Override
    public ResultList<List> getUnSettleOrderSumPageList(SettleBatch settleBatch){
        List list = orderMapper.getUnSettleOrderSumList(settleBatch);
        ResultList<List> re = new ResultList<List>(list.size(), System.currentTimeMillis(), list);
        return re;
    }

    @Override
    public ResultList<List> getUnSettleOrderPageList(PageVO pageVO){
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        List list = orderMapper.getUnSettleOrderList(pageVO.getParams());
        ResultList<List> re = new ResultList<List>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }
}
