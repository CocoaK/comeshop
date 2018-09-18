package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.MemberTrans;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IMemberTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member/trans")
public class MemberTransController extends BaseController<MemberTrans>{

    @Autowired
    private IMemberTransService memberTransService;

    @Override
    public IBaseService<MemberTrans> getBaseService() {
        return memberTransService;
    }

//    @RequestMapping(value = "/queryCartList")
//    public List<MemberTrans> queryCartList(@RequestBody MemberTrans memberTrans) throws Exception{
//        return memberTransService.queryCartList(memberTrans);
//    }
}
