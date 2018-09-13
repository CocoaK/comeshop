package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.vo.OrderVO;

public interface IOrderService extends IBaseService<Order> {

//    ResultEntity<Order> addForResultEntity(Order order);

    ResultEntity<Order> addOrder(OrderVO orderVO);
}
