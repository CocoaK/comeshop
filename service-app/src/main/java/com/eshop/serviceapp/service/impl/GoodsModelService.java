package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.mapper.GoodsModelMapper;
import com.eshop.serviceapp.model.GoodsMedia;
import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.service.IGoodsModelService;
import com.eshop.serviceapp.vo.GoodsModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsModelService extends BaseService<GoodsModel> implements IGoodsModelService {

    @Autowired
    private GoodsModelMapper goodsModelMapper;
    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

    @Override
    public BaseMapper<GoodsModel> getBaseMapper() {
        return goodsModelMapper;
    }

    @Override
    public ResultEntity getDetail(Integer zoneGoodsId) {
        GoodsModelVO goodsModelVO = goodsModelMapper.getDetail(zoneGoodsId);
        GoodsMedia media = new GoodsMedia();
        if(goodsModelVO==null){
            return new ResultEntity();
        }
        media.setGoodsModelId(goodsModelVO.getGoodsModelId());
        goodsModelVO.setGoodsModelImages(goodsMediaMapper.getSimpleList(media));
        return super.proccessResultEntity(goodsModelVO!=null ? ResultEntity.SUCCESS : ResultEntity.FAILD,goodsModelVO!=null ? ResultEntity.MSG_SUCCESS : ResultEntity.MSG_FAILED,goodsModelVO);
    }
}
