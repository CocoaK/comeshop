package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.GoodsMapper;
import com.eshop.serviceweb.model.Goods;
import com.eshop.serviceweb.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BaseService<Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public BaseMapper<Goods> getBaseMapper() {
        return goodsMapper;
    }
}
