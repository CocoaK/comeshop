package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.MemberCart;
import com.eshop.serviceapp.vo.MemberCartVO;

import java.util.List;

public interface IMemberCartService extends IBaseService<MemberCart> {

    List<MemberCartVO> queryCartList(MemberCart memberCart);

    ResultEntity<Integer> getCount(Integer memberId);

}
