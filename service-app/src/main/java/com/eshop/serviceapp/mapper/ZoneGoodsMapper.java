package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.vo.ZoneGoodsDetailVO;
import com.eshop.serviceapp.vo.ZoneGoodsVO;

import java.util.List;

public interface ZoneGoodsMapper extends BaseMapper<ZoneGoods> {

    List queryVoList(ZoneGoodsVO zoneGoodsVO);

    ZoneGoodsDetailVO getDetail(Integer zoneGoodsId);
}