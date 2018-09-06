package com.eshop.serviceweb.service.impl;

import com.eshop.serviceweb.common.model.ResultEntity;
import com.eshop.serviceweb.mapper.BaseMapper;
import com.eshop.serviceweb.mapper.CategoryMapper;
import com.eshop.serviceweb.model.Category;
import com.eshop.serviceweb.service.ICategoryService;
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

    public ResultEntity<String> addForResultEntity(Category category) {
        Category category1 = new Category();
        category.setCategoryCode("C"+System.currentTimeMillis());
        category1.setCategoryName(category.getCategoryName());
        List<Category> list = categoryMapper.getList(category1);
        if(list != null && !list.isEmpty()){
            return new ResultEntity<>(ResultEntity.FAILD,"Category name exist","");
        }
        int result = add(category);
        return proccessResultEntity(result > 0 ? ResultEntity.SUCCESS
                : ResultEntity.FAILD, result > 0 ? ResultEntity.MSG_SUCCESS : "", "");
    }
}
