package com.eshop.serviceapp.service.impl;

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

    @Override
    public List<CategoryVO> getSubList(Category category) {
        List<CategoryVO> list  = categoryMapper.getSubListByParentId(category.getCategoryId());
        return this.bulidSubCategory(list);
    }

    private List bulidSubCategory(List<CategoryVO> categoryVOList){
        //List<CategoryVO> categoryVOList = new ArrayList<CategoryVO>();
        for(CategoryVO categoryVO : categoryVOList){
//            CategoryVO categoryVO = new CategoryVO();
//            categoryVO.setCategoryCode(ca.getCategoryCode());
//            categoryVO.setCategoryId(ca.getCategoryId());
//            categoryVO.setCategoryName(ca.getCategoryName());
//            categoryVO.setCategoryImage(ca.getCategoryImage());

            //查询当前分类的子分类
            List<CategoryVO> li = categoryMapper.getSubListByParentId(categoryVO.getCategoryId());
            if(li!=null && !li.isEmpty()){
                bulidSubCategory(li);
                categoryVO.setChildren(li);
            }
        }
        return categoryVOList;
    }
}
