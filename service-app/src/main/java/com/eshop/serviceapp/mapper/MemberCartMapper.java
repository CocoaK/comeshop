package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.MemberCart;
import com.eshop.serviceapp.vo.MemberCartVO;

import java.util.List;

public interface MemberCartMapper extends BaseMapper<MemberCart> {

    List<MemberCartVO> queryCartList(MemberCart memberCart);
}