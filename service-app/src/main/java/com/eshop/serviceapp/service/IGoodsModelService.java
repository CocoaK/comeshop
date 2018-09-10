package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.GoodsModel;

public interface IGoodsModelService extends IBaseService<GoodsModel> {
    ResultEntity getDetail(Integer zoneGoodsId);
}
