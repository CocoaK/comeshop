package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.GoodsModelMapper;
import com.eshop.serviceweb.model.GoodsModel;
import com.eshop.serviceweb.service.IGoodsModelService;
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
