package com.lau.spider.mapper;

import com.lau.spider.model.Category;
import com.lau.spider.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper extends MyMapper<Category> {

    /**
     * 查询平台
     * @return
     */
    @Select("SELECT * FROM `category` where `status`=0 and type=#{type}")
    List<Category> typeList(Category category);


}