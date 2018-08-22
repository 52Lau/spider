package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.WelcomeDto;
import com.lau.spider.model.Category;
import com.lau.spider.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: CategoryController
 * @description: 分类
 * @author: Lau52y
 * @create: 2018-08-22 21:32
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public String getTyprList(@PathVariable("id") int id){
        Category category=new Category();
        category.setType(id);
        //WelcomeDto welcomeDto=new WelcomeDto();
        List<Category> categoryList = categoryService.typeList(category);
        //welcomeDto.setData(categoryList.toArray());
        return JSON.toJSONString(categoryList.toArray());
    }
}
