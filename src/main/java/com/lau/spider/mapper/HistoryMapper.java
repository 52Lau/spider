package com.lau.spider.mapper;

import com.lau.spider.model.History;
import com.lau.spider.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryMapper extends MyMapper<History> {
    @Select("select level1 from history where `status`=0 and level1 is not null and trim(level1) != '' GROUP BY level1")
    List<History> level1List();

    @Select("select level2 from history where `status`=0 and level2 is not null and trim(level2) != '' GROUP BY level2")
    List<History> level2List();
}