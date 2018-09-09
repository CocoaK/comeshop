package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.GoodsMediaMapper;
import com.eshop.serviceapp.mapper.ZoneGoodsMapper;
import com.eshop.serviceapp.mapper.ZoneMapper;
import com.eshop.serviceapp.model.Zone;
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
public class ZoneService extends BaseService<Zone> implements IZoneService {

    @Autowired
    private ZoneMapper zoneMapper;

    @Autowired
    private ZoneGoodsMapper zoneGoodsMapper;

    @Autowired
    private GoodsMediaMapper goodsMediaMapper;

    @Override
    public BaseMapper<Zone> getBaseMapper() {
        return zoneMapper;
    }

    @Override
    public List<ZoneVO> queryList(PageVO<Zone> pageVO) {
        List<Zone> zones = zoneMapper.getAll();
        List<ZoneVO> list = new ArrayList<ZoneVO>();
        for(Zone zone : zones){
            ZoneGoodsVO zoneGoods = new ZoneGoodsVO();
//            if(pageVO!=null && pageVO.getParams()!=null){
//                zoneGoods.setZoneCode(zone.getZoneCode());
//            }
            zoneGoods.setZoneCode(zone.getZoneCode());
            Page page = PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(),"disp_seq");
            List li = zoneGoodsMapper.queryVoList(zoneGoods);
            if(li!=null && !li.isEmpty()){
                ZoneVO zoneVO = new ZoneVO();
                zoneVO.setZoneCode(zone.getZoneCode());
                zoneVO.setZoneName(zone.getZoneName());
                zoneVO.setChildren(page);
                list.add(zoneVO);
            }
        }
        return list;
    }
}
