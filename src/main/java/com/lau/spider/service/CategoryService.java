package com.lau.spider.service;

import com.lau.spider.model.Category;

import java.util.List;

public interface CategoryService extends  IService<Category> {
    List<Category> typeList(Category category);
}
