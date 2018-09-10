package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.MemberCart;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.IMemberCartService;
import com.eshop.serviceapp.vo.LoginResultVO;
import com.eshop.serviceapp.vo.LoginVO;
import com.eshop.serviceapp.vo.MemberCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/member/cart")
public class MemberCartController extends BaseController<MemberCart>{

    @Autowired
    private IMemberCartService memberCartService;

    @Override
    public IBaseService<MemberCart> getBaseService() {
        return memberCartService;
    }

    @RequestMapping(value = "/queryCartList")
    public List<MemberCartVO> queryCartList(@RequestBody MemberCart memberCart) throws Exception{
        return memberCartService.queryCartList(memberCart);
    }

    @RequestMapping(value = "/getCount")
    public ResultEntity<Integer> getCount(@RequestBody MemberCart memberCart) throws Exception{
        if(memberCart==null || memberCart.getMemberId()==null){
            return new ResultEntity<Integer>();
        }
        return memberCartService.getCount(memberCart.getMemberId());
    }
}
