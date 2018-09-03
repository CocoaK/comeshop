package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.common.util.StringUtil;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.OrderMapper;
import com.eshop.serviceweb.model.Order;
import com.eshop.serviceweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public BaseMapper<Order> getBaseMapper() {
        return orderMapper;
    }

    @Override
    public ResultEntity<String> addForResultEntity(Order order) {
        order.setOrderNo(StringUtil.randomNum(7)+System.currentTimeMillis());
        int result = add(order);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}
