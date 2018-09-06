package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.Order;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
