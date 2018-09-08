package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.mapper.ZoneGoodsMapper;
import com.eshop.serviceapp.mapper.ZoneMapper;
import com.eshop.serviceapp.model.Zone;
import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.service.IZoneGoodsService;
import com.eshop.serviceapp.service.IZoneService;
import com.eshop.serviceapp.vo.PageVO;
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
}
