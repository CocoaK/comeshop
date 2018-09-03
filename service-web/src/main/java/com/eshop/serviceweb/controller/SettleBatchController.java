package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.SettleBatch;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.ISettleBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
