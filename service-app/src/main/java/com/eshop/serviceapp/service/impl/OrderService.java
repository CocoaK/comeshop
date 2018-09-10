package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.StringUtil;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.mapper.OrderMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseMapper<Order> getBaseMapper() {
        return orderMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(Order order) {
        order.setOrderNo(System.currentTimeMillis()+StringUtil.randomNum(7));
//        Member member = memberMapper.getOne(order.getMemberId());
//        order.setCurrentUser(member.getCurrentUser());
//        order.setCreatedBy(member.getUserName());
        int result = orderMapper.insertActive(order);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}
