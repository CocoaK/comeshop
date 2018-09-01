package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.Order;
import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    List<Order> getSettleOrderList(Order order);

    List<Order> getRechargeOrderList(Order order);
}