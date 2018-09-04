package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.GoodsMapper;
import com.eshop.serviceweb.mapper.ZoneGoodsMapper;
import com.eshop.serviceweb.model.Goods;
import com.eshop.serviceweb.model.ZoneGoods;
import com.eshop.serviceweb.service.IGoodsService;
import com.eshop.serviceweb.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService extends BaseService<Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ZoneGoodsMapper zoneGoodsMapper;

    @Override
    public BaseMapper<Goods> getBaseMapper() {
        return goodsMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity<String> addForResultEntity(GoodsVO goodsVO) {
        ResultEntity<String> re = new ResultEntity<String>();
        if(null == goodsVO){
            return re;
        }
        int result = add(goodsVO);
        ZoneGoods zoneGoods = new ZoneGoods();
        zoneGoods.setBuCode(goodsVO.getBuCode());
        zoneGoods.setCreatedBy(goodsVO.getCreatedBy());
        zoneGoods.setDiscountAmt(goodsVO.getDiscontAmt());
        zoneGoods.setGoodsId(goodsVO.getGoodsId());
        goodsVO.setGoodsCode("g"+System.currentTimeMillis());
//        int result = add(goodsVO);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}
