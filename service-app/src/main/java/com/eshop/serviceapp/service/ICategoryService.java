package com.eshop.serviceapp.service;

import com.eshop.serviceapp.model.Category;
import com.eshop.serviceapp.vo.CategoryVO;
import java.util.List;

public interface ICategoryService extends IBaseService<Category> {

    List<CategoryVO> getSubList(Category category);
}
