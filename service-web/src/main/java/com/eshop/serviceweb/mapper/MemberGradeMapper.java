package com.eshop.serviceweb.mapper;

import com.eshop.serviceweb.model.MemberGrade;
import com.eshop.serviceweb.view.MemberAndGradeView;

import java.util.List;
import java.util.Map;

public interface MemberGradeMapper extends BaseMapper<MemberGrade> {
    List<MemberAndGradeView> getMemberAndGradeAll();
}