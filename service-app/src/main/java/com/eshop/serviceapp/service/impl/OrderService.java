package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.OrderMapper;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.service.IOrderService;
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

}
