package com.eshop.serviceapp.service;

import com.eshop.serviceapp.model.Zone;
import com.eshop.serviceapp.vo.PageVO;
import com.eshop.serviceapp.vo.ZoneVO;
import java.util.List;

public interface IZoneService extends IBaseService<Zone> {

    List<ZoneVO> queryList(PageVO<Zone> pageVO);
}
