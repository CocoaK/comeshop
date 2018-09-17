package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.vo.OrderListVO;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    List<OrderListVO> queryPageVOList(Order order);
}