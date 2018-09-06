package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.MemberAddress;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IMemberAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member/address")
public class MemberAddressController extends BaseController<MemberAddress>{

    @Autowired
    private IMemberAddressService memberAddressService;

    @Override
    public IBaseService<MemberAddress> getBaseService() {
        return memberAddressService;
    }
}
