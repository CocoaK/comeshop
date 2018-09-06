package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.model.Goods;
import com.eshop.serviceapp.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends BaseService<Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

       @Override
    public BaseMapper<Goods> getBaseMapper() {
        return goodsMapper;
    }

}
