package com.eshop.serviceapp.service.impl;

import com.eshop.serviceapp.common.model.ResultEntity;
import com.eshop.serviceapp.mapper.BaseMapper;
import com.eshop.serviceapp.mapper.CategoryMapper;
import com.eshop.serviceapp.model.Category;
import com.eshop.serviceapp.service.ICategoryService;
import com.eshop.serviceapp.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public BaseMapper<Category> getBaseMapper() {
        return categoryMapper;
    }

//    public ResultEntity<CategoryVO> (Category category) {
//
//    }

}
