package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.MemberExchange;
import com.eshop.serviceapp.model.MemberTrans;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IMemberExchangeService;
import com.eshop.serviceapp.service.IMemberTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member/exchange")
public class MemberExchangeController extends BaseController<MemberExchange>{

    @Autowired
    private IMemberExchangeService memberExchangeService;

    @Override
    public IBaseService<MemberExchange> getBaseService() {
        return memberExchangeService;
    }

}
