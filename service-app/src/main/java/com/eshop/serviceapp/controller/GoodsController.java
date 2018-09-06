package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.Goods;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController extends BaseController<Goods>{

    @Autowired
    private IGoodsService goodsService;

    @Override
    public IBaseService<Goods> getBaseService() {
        return goodsService;
    }

}
