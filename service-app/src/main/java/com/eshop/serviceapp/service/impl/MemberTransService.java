package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.StringUtil;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.mapper.MemberTransMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.model.MemberTrans;
import com.eshop.serviceapp.service.IMemberTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MemberTransService extends BaseService<MemberTrans> implements IMemberTransService {

    @Autowired
    private MemberTransMapper memberTransMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseMapper<MemberTrans> getBaseMapper() {
        return memberTransMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity<MemberTrans> addForResultEntity(MemberTrans memberTrans) {
        memberTrans.setCurrentUser("[SYS]");
        memberTrans.setTransDate(new Date());
        Member member = memberMapper.getOne(memberTrans.getMemberId());
        memberTrans.setTransMp(memberTrans.getTransAmt().intValue());
        memberTrans.setTransNo("T"+System.currentTimeMillis() + StringUtil.randomNum(5));
        memberTrans.setTransType("1");
        memberTrans.setBuCode(Constants.BU_CODE);
        //积分
        memberTrans.setTransMpBal(memberTrans.getTransMp() + member.getMpAmt());
        //余额
        memberTrans.setTransAmtBal(memberTrans.getTransAmt().add(member.getBalAmt()));
        int result = add(memberTrans);
        //更新会员的余额(上期余额+本次充值金额)
        member.setBalAmt(memberTrans.getTransAmtBal());
        memberMapper.updateActiveByLock(member);
        MemberTrans mTrans = memberTransMapper.getOne(memberTrans.getTransId());
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", mTrans);
    }

}
