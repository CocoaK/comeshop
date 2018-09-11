package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.GoodsModel;
import com.eshop.serviceapp.model.ZoneGoods;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IGoodsModelService;
import com.eshop.serviceapp.vo.GoodsModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/goods/model")
public class GoodsModelController extends BaseController<GoodsModel>{

    @Autowired
    private IGoodsModelService goodsModelService;

    @Override
    public IBaseService<GoodsModel> getBaseService() {
        return goodsModelService;
    }

    @RequestMapping(value = "/getDetail")
    public @ResponseBody
    List<GoodsModelVO> getDetail(@RequestBody ZoneGoods zoneGoods){
        return goodsModelService.getDetail(zoneGoods.getGoodsId());
    }
}
