package com.lau.spider.mapper;

import com.lau.spider.model.Youtube;
import com.lau.spider.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface YoutubeMapper extends MyMapper<Youtube> {
    @Insert("INSERT INTO `baidu`.`youtube`( `name`, `url`, `videoId`) VALUES (#{name}, #{url}, #{videoid});")
    int  insertYoutuBe(Youtube youtube);
}