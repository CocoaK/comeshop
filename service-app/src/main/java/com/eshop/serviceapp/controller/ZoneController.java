package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.Zone;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IZoneService;
import com.eshop.serviceapp.vo.PageVO;
import com.eshop.serviceapp.vo.ZoneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/zone")
public class ZoneController extends BaseController<Zone>{

    @Autowired
    private IZoneService zoneService;

    @Override
    public IBaseService<Zone> getBaseService() {
        return zoneService;
    }

    @RequestMapping(value = "/queryList")
    public @ResponseBody List<ZoneVO> queryList(@RequestBody PageVO<Zone> pageVO){
        return zoneService.queryList(pageVO);
    }
}
