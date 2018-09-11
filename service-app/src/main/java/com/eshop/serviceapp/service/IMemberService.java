package com.eshop.serviceapp.service;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.model.Member;
import com.eshop.serviceapp.vo.MemberVO;

public interface IMemberService extends IBaseService<Member>{

    ResultEntity<Member> addForResultEntity(MemberVO memberVO);
}
