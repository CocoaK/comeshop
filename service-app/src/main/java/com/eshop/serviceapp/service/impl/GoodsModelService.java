package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.mapper.GoodsModelMapper;
import com.eshop.serviceapp.model.GoodsMedia;
import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.service.IGoodsModelService;
import com.eshop.serviceapp.vo.GoodsModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<GoodsModelVO> getDetail(Integer goodsId) {
        List<GoodsModelVO> list = goodsModelMapper.getDetail(goodsId);
        GoodsMedia media = new GoodsMedia();
        if(list==null){
            return list;
        }
        for(GoodsModelVO vo : list){
            media.setGoodsModelId(vo.getGoodsModelId());
            vo.setGoodsModelImages(goodsMediaMapper.getSimpleList(media));
        }
        return list;
    }
}
