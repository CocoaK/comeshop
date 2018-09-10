package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.GoodsMedia;

import java.util.List;

public interface GoodsMediaMapper extends BaseMapper<GoodsMedia> {
    List<Object> getSimpleList(GoodsMedia media);
}