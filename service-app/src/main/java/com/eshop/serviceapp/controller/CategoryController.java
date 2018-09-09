package com.eshop.serviceapp.controller;

import com.eshop.serviceapp.common.model.ResultList;
import com.eshop.serviceapp.model.Category;
import com.eshop.serviceapp.service.IBaseService;
import com.eshop.serviceapp.service.ICategoryService;
import com.eshop.serviceapp.vo.CategoryVO;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController extends BaseController<Category>{

    @Autowired
    private ICategoryService categoryService;

    @Override
    public IBaseService<Category> getBaseService() {
        return categoryService;
    }

    @RequestMapping("/getSubList")
    public @ResponseBody
    List<CategoryVO> getSubList(@RequestBody Category category) {
        return categoryService.getSubList(category);
    }
}
