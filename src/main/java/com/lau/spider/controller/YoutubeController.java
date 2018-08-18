package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Youtube;
import com.lau.spider.service.YoutubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: MusicController
 * @description: 网易云音乐
 * @author: Lau52y
 * @create: 2018-08-12 21:41
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="youtube",produces = "application/json; charset=utf-8")
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @RequestMapping("list")
    public String list(Youtube youtube, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = youtubeService.findPage(youtube,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("order-edit2");
        Youtube youtube = youtubeService.selectByKey(id);
        result.addObject("youtube", youtube);
        return result;
    }



}
