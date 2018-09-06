package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.model.Goods;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IGoodsService;
import com.eshop.serviceweb.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/create")
    public ResultEntity<String> login(@Validated @RequestBody GoodsVO goodsVO) throws Exception{
        return goodsService.addForResultEntity(goodsVO);
    }
}
