package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService extends BaseService<Member> implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseMapper<Member> getBaseMapper() {
        return memberMapper;
    }

    @Override
    public ResultEntity<Member> addForResultEntity(Member member) {
        Member mem = new Member();
        mem.setUserName(member.getUserName());
        List<Member> list = memberMapper.getList(mem);
        if(list!=null && !list.isEmpty()){
            return new ResultEntity(ResultEntity.ALREADY_EXIST,"username exist",null);
        }
        int result = memberMapper.insertActive(member);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", member);
    }
}
