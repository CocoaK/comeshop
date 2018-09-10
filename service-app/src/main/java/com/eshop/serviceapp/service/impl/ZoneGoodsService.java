package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.mapper.ZoneGoodsMapper;
import com.eshop.serviceapp.mapper.ZoneMapper;
import com.eshop.serviceapp.model.GoodsMedia;
import com.eshop.serviceapp.model.Zone;
import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.service.IZoneGoodsService;
import com.eshop.serviceapp.service.IZoneService;
import com.eshop.serviceapp.vo.PageVO;
import com.eshop.serviceapp.vo.ZoneGoodsDetailVO;
import com.eshop.serviceapp.vo.ZoneGoodsVO;
import com.eshop.serviceapp.vo.ZoneVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneGoodsService extends BaseService<ZoneGoods> implements IZoneGoodsService {

    @Autowired
    private ZoneGoodsMapper zoneGoodsMapper;

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

    @Override
    public BaseMapper<ZoneGoods> getBaseMapper() {
        return zoneGoodsMapper;
    }

    @Override
    public ResultList queryList(PageVO<ZoneGoodsVO> pageVO) {
        Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),pageVO.getOrderBy());
        zoneGoodsMapper.queryVoList(pageVO.getParams());
        return new ResultList(page.getTotal(), System.currentTimeMillis(), page);
    }

    @Override
    public ResultEntity<ZoneGoodsDetailVO> getDetail(Integer zoneGoodsId) {
        ZoneGoodsDetailVO zoneGoodsDetailVO = zoneGoodsMapper.getDetail(zoneGoodsId);
        ZoneGoods zoneGoods = zoneGoodsMapper.getOne(zoneGoodsId);
        if(zoneGoods == null || zoneGoodsDetailVO == null){
            return new ResultEntity<>();
        }
        GoodsMedia media = new GoodsMedia();
        media.setGoodsId(zoneGoods.getGoodsId());
        List<Object> goodsImages = goodsMediaMapper.getSimpleList(media);
        zoneGoodsDetailVO.setGoodsImage(goodsImages);
        return new ResultEntity(ResultEntity.SUCCESS, ResultEntity.MSG_SUCCESS, zoneGoodsDetailVO);
    }
}
