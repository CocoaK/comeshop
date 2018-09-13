package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IOrderService;
import com.eshop.serviceapp.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends BaseController<Order>{

    @Autowired
    private IOrderService orderService;

    @Override
    public IBaseService<Order> getBaseService() {
        return orderService;
    }

    @RequestMapping("/addOrder")
    public @ResponseBody
    ResultEntity<Order> addOrder(@Validated @RequestBody OrderVO orderVO) {
        return orderService.addOrder(orderVO);
    }
}
