package com.eshop.serviceapp.mapper;

import com.eshop.serviceapp.model.Category;
import com.eshop.serviceapp.vo.CategoryVO;
import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVO> getSubListByParentId(Integer categoryId);
}