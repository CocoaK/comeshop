package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsModelMapper;
import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.service.IGoodsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsModelService extends BaseService<GoodsModel> implements IGoodsModelService {

    @Autowired
    private GoodsModelMapper goodsModelMapper;

    @Override
    public BaseMapper<GoodsModel> getBaseMapper() {
        return goodsModelMapper;
    }
}
