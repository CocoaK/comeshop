package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Order;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IOrderService;
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
