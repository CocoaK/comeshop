package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.service.IMemberService;
import com.eshop.serviceapp.vo.MemberVO;
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

//    @Override
//    public ResultEntity<Member> addForResultEntity(Member member) {
//        Member mem = new Member();
//        mem.setUserName(member.getUserName());
//        List<Member> list = memberMapper.getList(mem);
//        if(list!=null && !list.isEmpty()){
//            return new ResultEntity(ResultEntity.ALREADY_EXIST,"username exist",null);
//        }
//        int result = memberMapper.insertActive(member);
//        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
//                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", member);
//    }

    @Override
    public ResultEntity<Member> addForResultEntity(MemberVO memberVO) {
        Member mem = new Member();
        mem.setUserName(memberVO.getUserName());
        List<Member> list = memberMapper.getList(mem);
        if(list!=null && !list.isEmpty()){
            return new ResultEntity(ResultEntity.ALREADY_EXIST,"username exist",null);
        }
        Member m = new Member();
        m.setUserName(memberVO.getRefMemberUser());
        List<Member> refMemberList = memberMapper.getList(m);
        Integer refMemberId = null;
        if(refMemberList != null && !refMemberList.isEmpty()){
            refMemberId = refMemberList.get(0).getRefMemberId();
        }

        Member member = new Member();
        member.setUserName(memberVO.getUserName());
        member.setPassword(memberVO.getPassword());
        member.setTelephone(memberVO.getTelephone());
        member.setRefMemberId(1);
        member.setCurrentUser("[SYS]");
        member.setIsActive(true);
        member.setBuCode("ESHOP");
        member.setRefMemberId(refMemberId);
        int result = memberMapper.insertActive(member);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", memberMapper.getOne(member.getMemberId()));
    }
}
