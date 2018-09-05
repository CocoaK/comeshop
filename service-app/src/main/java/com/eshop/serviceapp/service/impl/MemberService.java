package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends BaseService<Member> implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseMapper<Member> getBaseMapper() {
        return memberMapper;
    }
}
