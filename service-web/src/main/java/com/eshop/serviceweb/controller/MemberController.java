package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Member;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.IMemberService;
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
