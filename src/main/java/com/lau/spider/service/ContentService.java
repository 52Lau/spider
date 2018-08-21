package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Content;

public interface ContentService extends  IService<Content> {
    LayuiDto findPage(Content content, int page, int limit);
}
