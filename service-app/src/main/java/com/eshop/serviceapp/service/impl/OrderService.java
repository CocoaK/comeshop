package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.common.util.StringUtil;
import com.eshop.serviceapp.mapper.*;
import com.eshop.serviceapp.model.*;
import com.eshop.serviceapp.service.IOrderService;
import com.eshop.serviceapp.vo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

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
            o.setMpAmt((orderAmount.multiply(new BigDecimal(rebateSetting.getExchangeRate())).setScale(0).intValue()));
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

    @Override
    public ResultList<List<OrderListVO>> queryPageVOList(PageVO<Order> pageVO){
        Page<OrderListVO> page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        List<OrderListVO> list = orderMapper.queryPageVOList(pageVO.getParams());
        if(list == null || list.isEmpty()){
            return new ResultList<List<OrderListVO>>();
        }
        for(OrderListVO vo : list){
            ZoneGoodsVO zoneGoodsVO = new ZoneGoodsVO();
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(vo.getOrderId());

            List<OrderDetails> orderDetailsList = orderDetailsMapper.getList(orderDetails);
            List<OrderDetailGoodsVO> orderDetailGoodsVOList = new ArrayList<OrderDetailGoodsVO>();
            if(orderDetailsList!=null && !orderDetailsList.isEmpty()){
                for(OrderDetails odrDetails : orderDetailsList){
                    ZoneGoodsDetailVO zoneGoodsDetailVO = zoneGoodsMapper.getDetail(odrDetails.getZoneGoodsId());
                    GoodsMedia media = new GoodsMedia();
                    media.setGoodsId(zoneGoodsDetailVO.getGoodsId());
                    List<Object> goodsImages = goodsMediaMapper.getSimpleList(media);
                    zoneGoodsDetailVO.setGoodsImage(goodsImages);
                    //组建返回值
                    OrderDetailGoodsVO orderDetailGoodsVO = new OrderDetailGoodsVO();
                    orderDetailGoodsVO.setAmount(odrDetails.getAmount());
                    orderDetailGoodsVO.setNetAmt(odrDetails.getNetAmt());
                    orderDetailGoodsVO.setOrderQty(odrDetails.getOrderQty());
                    orderDetailGoodsVO.setProfitAmt(odrDetails.getProfitAmt());
                    orderDetailGoodsVO.setRebateAmt(odrDetails.getRebateAmt());
                    orderDetailGoodsVO.setGoodsImage(zoneGoodsDetailVO.getGoodsImage());
                    orderDetailGoodsVO.setGoodsBrief(zoneGoodsDetailVO.getGoodsBrief());
                    orderDetailGoodsVO.setGoodsCode(zoneGoodsDetailVO.getGoodsCode());
                    orderDetailGoodsVO.setGoodsDesc(zoneGoodsDetailVO.getGoodsDesc());
                    orderDetailGoodsVO.setGoodsId(zoneGoodsDetailVO.getGoodsId());
                    orderDetailGoodsVO.setGoodsName(zoneGoodsDetailVO.getGoodsName());
                    orderDetailGoodsVO.setPrice(zoneGoodsDetailVO.getPrice());
                    orderDetailGoodsVO.setZoneCode(zoneGoodsDetailVO.getZoneCode());
                    orderDetailGoodsVO.setZoneGoodsId(zoneGoodsDetailVO.getZoneGoodsId());
                    orderDetailGoodsVOList.add(orderDetailGoodsVO);
                }
            }
            vo.setZoneGoods(orderDetailGoodsVOList);
        }
        ResultList<List<OrderListVO>> re = new ResultList<List<OrderListVO>>(page.getTotal(), System.currentTimeMillis(), page);
        return re;
    }
}
