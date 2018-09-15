package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.StringUtil;
import com.eshop.serviceapp.mapper.*;
import com.eshop.serviceapp.model.*;
import com.eshop.serviceapp.service.IOrderService;
import com.eshop.serviceapp.vo.OrderDetailVO;
import com.eshop.serviceapp.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService extends BaseService<Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RebateSettingMapper rebateSettingMapper;
    @Autowired
    private ZoneGoodsMapper zoneGoodsMapper;
    @Autowired
    private GoodsModelMapper goodsModelMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Override
    public BaseMapper<Order> getBaseMapper() {
        return orderMapper;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity<Order> addOrder(OrderVO orderVO) {
        ResultEntity<Order> re = new ResultEntity<Order>();
        try {
            //组建订单信息
            Order order = new Order();
            //订单编号
            order.setOrderNo(System.currentTimeMillis() + StringUtil.randomNum(7));
            RebateSetting rebateSetting = rebateSettingMapper.getAll().get(0);
            Member member = memberMapper.getOne(orderVO.getMemberId());
            order.setCurrentUser(member.getUserName());
            order.setCreatedBy(member.getUserName());
            if (orderVO.getBuCode() == null || "".equals(orderVO.getBuCode())) {
                order.setBuCode("ESHOP");
            } else {
                order.setBuCode(orderVO.getBuCode());
            }
            order.setSettleStatus(Constants.ORDER_SETTLE_STATUS_UNSETTLED);
            order.setStatus(Constants.ORDER_STATUS_UNPAID);
            order.setZoneCode(orderVO.getZoneCode());
            order.setMemberId(orderVO.getMemberId());
            order.setMemberGradeCode(member.getMemberGrade());
            order.setMemberAddressId(orderVO.getMemberAddressId());
            order.setAmount(new BigDecimal(0));
            order.setMpAmt(0);
            int result = orderMapper.insertActive(order);
            //订单明细
            List<OrderDetailVO> detailList = orderVO.getOrderDetails();
            BigDecimal orderAmount = new BigDecimal(0);
            if (detailList != null && !detailList.isEmpty()) {
                for (OrderDetailVO vo : detailList) {
                    ZoneGoods zoneGoods = zoneGoodsMapper.getOne(vo.getZoneGoodsId());
                    GoodsModel goodsModel = goodsModelMapper.getOne(zoneGoods.getGoodsModelId());
                    //商品总价
                    BigDecimal amount = goodsModel.getPrice().multiply(new BigDecimal(vo.getOrderQty()));
                    //商品型号数量*商品型号价格-商品折扣
                    BigDecimal netAmt = amount.subtract(zoneGoods.getDiscountAmt());
                    orderAmount = orderAmount.add(netAmt);
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setAmount(amount);
                    orderDetails.setOrderId(order.getOrderId());
                    orderDetails.setOrderQty(vo.getOrderQty());
                    if (!vo.getNetAmt().equals(netAmt)) {
                        //如果价格跟前端算的不一致
                    }
                    orderDetails.setNetAmt(netAmt);
                    orderDetails.setRebateAmt(netAmt);
                    orderDetails.setProfitAmt(zoneGoods.getProfitAmt());
                    orderDetails.setZoneGoodsId(vo.getZoneGoodsId());
                    orderDetails.setOrderId(order.getOrderId());
                    orderDetails.setCurrentUser(member.getUserName());
                    orderDetails.setBuCode(order.getBuCode());
                    orderDetailsMapper.insertActive(orderDetails);
                }
            }
            Order o = orderMapper.getOne(order.getOrderId());
            o.setAmount(orderAmount);
            //积分=订单总金额*积分兑换比
            o.setMpAmt(Integer.parseInt((orderAmount.multiply(new BigDecimal(rebateSetting.getExchangeRate())).setScale(0).toString())));
            orderMapper.updateActive(o);
            re.setCode(ResultEntity.SUCCESS);
            re.setMsg(ResultEntity.MSG_SUCCESS);
            re.setData(o);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return re;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity<Order> updateActiveOrder(Order order) {
        ResultEntity<Order> re = new ResultEntity<Order>();
        Order odr = new Order();
        if(order == null || order.getLastUpdatedBy() == null || order.getLastUpdatedDate() == null || order.getOrderId() == null){
            return re;
        }
        odr.setOrderId(order.getOrderId());
        odr.setLastUpdatedBy(order.getLastUpdatedBy());
        odr.setLastUpdatedDate(order.getLastUpdatedDate());
        odr.setStatus(order.getStatus());
        Member member = memberMapper.getOne(order.getMemberId());
        if(member!=null){
            odr.setCurrentUser(member.getUserName());
        }
        int result = orderMapper.updateActiveByLock(odr);
        if(result>0){
            re.setCode(ResultEntity.SUCCESS);
            re.setMsg(ResultEntity.MSG_SUCCESS);
            re.setData(orderMapper.getOne(order.getOrderId()));
        }
        return re;
    }
}
