package com.lau.spider.mapper;

import com.lau.spider.model.Wish;
import com.lau.spider.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WishMapper extends MyMapper<Wish> {
    @Select("SELECT * FROM wish ORDER BY createdate desc LIMIT 5;")
    List<Wish> findTop();

    @Insert("INSERT INTO `baidu`.`wish`(`context`) VALUES (#{context});")
    int insert(Wish wish);
}