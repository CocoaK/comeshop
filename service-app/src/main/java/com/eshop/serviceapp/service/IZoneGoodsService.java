package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.vo.PageVO;
import com.eshop.serviceapp.vo.ZoneGoodsVO;

public interface IZoneGoodsService extends IBaseService<ZoneGoods> {

    ResultList queryList(PageVO<ZoneGoodsVO> pageVO);

    ResultEntity getDetail(Integer zoneGoodsId);

}
