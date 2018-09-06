package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
public class MemberController extends BaseController<Member>{

    @Autowired
    private IMemberService memberService;

    @Override
    public IBaseService<Member> getBaseService() {
        return memberService;
    }
}
