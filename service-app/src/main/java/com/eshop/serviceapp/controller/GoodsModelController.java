package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IGoodsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods/model")
public class GoodsModelController extends BaseController<GoodsModel>{

    @Autowired
    private IGoodsModelService goodsModelService;

    @Override
    public IBaseService<GoodsModel> getBaseService() {
        return goodsModelService;
    }

}
