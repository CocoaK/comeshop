package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.vo.GoodsModelVO;

import java.util.List;

public interface IGoodsModelService extends IBaseService<GoodsModel> {
    List<GoodsModelVO> getDetail(Integer goodsId);
}
