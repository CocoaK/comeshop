package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.model.Zone;
import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IZoneGoodsService;
import com.eshop.serviceapp.service.IZoneService;
import com.eshop.serviceapp.vo.PageVO;
import com.eshop.serviceapp.vo.ZoneGoodsVO;
import com.eshop.serviceapp.vo.ZoneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zone/goods")
public class ZoneGoodsController extends BaseController<ZoneGoods>{

    @Autowired
    private IZoneGoodsService zoneGoodsService;

    @Override
    public IBaseService<ZoneGoods> getBaseService() {
        return zoneGoodsService;
    }

    @RequestMapping(value = "/queryList")
    public @ResponseBody
    ResultList queryList(@RequestBody PageVO<ZoneGoodsVO> pageVO){
        return zoneGoodsService.queryList(pageVO);
    }
}
