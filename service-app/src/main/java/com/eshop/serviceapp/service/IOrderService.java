package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.vo.OrderVO;

public interface IOrderService extends IBaseService<Order> {

    ResultEntity<Order> addOrder(OrderVO orderVO);

    ResultEntity<Order> updateActiveOrder(Order order);
}
