package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.common.model.ResultList;
import com.eshop.serviceweb.common.util.CryptUtil;
import com.eshop.serviceweb.model.SettleDetails;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.ISettleDetailsService;
import com.eshop.serviceweb.vo.PageVO;
import com.eshop.serviceweb.vo.SettleDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
