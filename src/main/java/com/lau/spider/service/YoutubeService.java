package com.lau.spider.service;

import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Youtube;

import java.util.List;

/**
 * @program: YoutubeService
 * @description: Youtube服务层接口
 * @author: Lau52y
 * @create: 2018-08-10 00:09
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/

public interface YoutubeService extends  IService<Youtube> {

    int insertYoutuBe(Youtube youtube);

    LayuiDto findPage(Youtube youtube, int page, int limit);
}
