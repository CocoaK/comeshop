package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.MemberMapper;
import com.eshop.serviceweb.model.Member;
import com.eshop.serviceweb.service.IMemberService;
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
    public ResultEntity<String> addForResultEntity(Member member) {
        Member memb = new Member();
        memb.setUserName(member.getUserName());
        List<Member> list = memberMapper.getList(memb);
        if(list.size()>0){
            return proccessResultEntity(ResultEntity.ALREADY_EXIST, ResultEntity.MSG_FAILED, "memberName exist!");
        }
        int result = add(member);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}
