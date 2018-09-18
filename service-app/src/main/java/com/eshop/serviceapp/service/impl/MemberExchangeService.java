package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.Constants;
import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.common.util.StringUtil;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberExchangeMapper;
import com.eshop.serviceapp.mapper.MemberMapper;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.model.MemberExchange;
import com.eshop.serviceapp.service.IMemberExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberExchangeService extends BaseService<MemberExchange> implements IMemberExchangeService {

    @Autowired
    private MemberExchangeMapper memberExchangeMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public BaseMapper<MemberExchange> getBaseMapper() {
        return memberExchangeMapper;
    }

    @Override
    public ResultEntity<MemberExchange> addForResultEntity(MemberExchange memberExchange) {
        memberExchange.setCurrentUser("[SYS]");
        memberExchange.setApplicationDate(new Date());
        memberExchange.setBuCode(Constants.BU_CODE);
        memberExchange.setStatus(Constants.MEMBER_EXCHANGE_STATUS_PENDING);
        memberExchange.setAccountType(Constants.ACCOUNT_TYPE_WECHAT);
        Member member = memberMapper.getOne(memberExchange.getMemberId());
        int result = add(memberExchange);
        //更新会员的余额(上期余额+本次充值金额)
        member.setLockedMpAmt(member.getLockedMpAmt() + memberExchange.getExchangeMp());
        memberMapper.updateActiveByLock(member);
        MemberExchange mExchange = memberExchangeMapper.getOne(memberExchange.getMemberExchangeId());
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", mExchange);
    }

}
