package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.GoodsMediaMapper;
import com.eshop.serviceweb.model.GoodsMedia;
import com.eshop.serviceweb.service.IGoodsMediaService;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsMediaService extends BaseService<GoodsMedia> implements IGoodsMediaService {

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;
    
    @Override
    public BaseMapper<GoodsMedia> getBaseMapper() {
        return goodsMediaMapper;
    }
}
