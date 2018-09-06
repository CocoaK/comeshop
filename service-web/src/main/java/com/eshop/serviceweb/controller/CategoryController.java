package com.eshop.serviceweb.controller;

import com.eshop.serviceweb.model.Category;
import com.eshop.serviceweb.service.IBaseService;
import com.eshop.serviceweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BaseController<Category>{

    @Autowired
    private ICategoryService categoryService;

    @Override
    public IBaseService<Category> getBaseService() {
        return categoryService;
    }

}
