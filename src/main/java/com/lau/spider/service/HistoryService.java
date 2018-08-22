package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.History;

import java.util.List;

public interface HistoryService extends  IService<History> {
    LayuiDto findPage(History history, int page, int limit);
    List<History> level1List();
    List<History> level2List();
}
