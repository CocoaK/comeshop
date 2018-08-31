package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.SettleDetails;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.ISettleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/settle/details")
public class SettleDetailsController extends BaseController<SettleDetails>{

    @Autowired
    private ISettleDetailsService settleDetailsService;

    @Override
    public IBaseService<SettleDetails> getBaseService() {
        return settleDetailsService;
    }
}
