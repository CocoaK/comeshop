package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.model.GoodsMedia;
import com.eshop.serviceapp.service.IGoodsMediaService;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsMediaService extends BaseService<GoodsMedia> implements IGoodsMediaService {

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;
    
    @Override
    public BaseMapper<GoodsMedia> getBaseMapper() {
        return goodsMediaMapper;
    }
}
