package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.MemberCartMapper;
import com.eshop.serviceapp.model.MemberCart;
import com.eshop.serviceapp.service.IMemberCartService;
import com.eshop.serviceapp.vo.MemberCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberCartService extends BaseService<MemberCart> implements IMemberCartService {

    @Autowired
    private MemberCartMapper memberCartMapper;

    @Override
    public BaseMapper<MemberCart> getBaseMapper() {
        return memberCartMapper;
    }

    @Override
    public List<MemberCartVO> queryCartList(MemberCart memberCart) {
        List<MemberCartVO> list = memberCartMapper.queryCartList(memberCart);
        return list;
    }

    @Override
    public ResultEntity<Integer> getCount(Integer memberId){
        ResultEntity<Integer> re = new ResultEntity<Integer>();
        Integer count = memberCartMapper.getCount(memberId);
        if(count!=null){
            re.setCode(ResultEntity.SUCCESS);
            re.setMsg(ResultEntity.MSG_SUCCESS);
            re.setData(count);
        }
        return re;
    }
}
