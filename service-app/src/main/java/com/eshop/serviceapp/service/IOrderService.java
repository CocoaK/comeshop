package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.Order;

public interface IOrderService extends IBaseService<Order> {

    ResultEntity<String> addForResultEntity(Order order);
}
