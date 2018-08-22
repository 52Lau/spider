package com.lau.spider.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.mapper.CategoryMapper;
import com.lau.spider.model.Category;
import com.lau.spider.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: CategoryServiceImpl
 * @description: Category服务层实现层
 * @author: Lau52y
 * @create: 2018-08-10 00:10
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public List<Category> typeList(Category category) {
        return categoryMapper.typeList(category);
    }
}
