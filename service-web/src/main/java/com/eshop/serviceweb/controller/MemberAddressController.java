package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Member;
import com.eshop.serviceweb.model.MemberAddress;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IMemberAddressService;
import com.eshop.serviceweb.service.IMemberService;
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
