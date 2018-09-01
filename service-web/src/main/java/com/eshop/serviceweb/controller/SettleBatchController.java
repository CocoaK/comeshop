package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.common.util.CryptUtil;
import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.ISettleBatchService;
import com.eshop.serviceweb.vo.PageVO;
import com.eshop.serviceweb.vo.SettleBatchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/settle/batch")
public class SettleBatchController extends BaseController<SettleBatch>{

    @Autowired
    private ISettleBatchService settleBatchService;

    @Override
    public IBaseService<SettleBatch> getBaseService() {
        return settleBatchService;
    }

}
