package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.vo.GoodsModelVO;


public interface GoodsModelMapper extends BaseMapper<GoodsModel> {

    GoodsModelVO getDetail(Integer zoneGoodsId);
}