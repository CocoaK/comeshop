package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.vo.GoodsModelVO;

import java.util.List;


public interface GoodsModelMapper extends BaseMapper<GoodsModel> {

    List<GoodsModelVO> getDetail(Integer goodsId);
}