package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.vo.OrderListVO;
import com.eshop.serviceapp.vo.OrderVO;
import com.eshop.serviceapp.vo.PageVO;

import java.util.List;

public interface IOrderService extends IBaseService<Order> {

    ResultEntity<Order> addOrder(OrderVO orderVO);

    ResultEntity<Order> updateActiveOrder(Order order);

    ResultList<List<OrderListVO>> queryPageVOList(PageVO<Order> pageVO);
}
