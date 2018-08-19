package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface WishService extends  IService<Wish> {

    LayuiDto findPage(Wish wish, int page, int limit);

    List<Wish> findTop();

    int insert(Wish wish);
}
