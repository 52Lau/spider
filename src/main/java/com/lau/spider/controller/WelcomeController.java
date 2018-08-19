package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.WelcomeDto;
import com.lau.spider.mapper.HistoryMapper;
import com.lau.spider.mapper.MusicMapper;
import com.lau.spider.mapper.WishMapper;
import com.lau.spider.mapper.YoutubeMapper;
import com.lau.spider.model.History;
import com.lau.spider.model.Music;
import com.lau.spider.model.Wish;
import com.lau.spider.model.Youtube;
import com.lau.spider.service.WishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: WelcomeController
 * @description: welcome
 * @author: Lau52y
 * @create: 2018-08-19 22:53
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="welcome",produces = "application/json; charset=utf-8")
public class WelcomeController {
    @Autowired
    WishMapper wishMapper;
    @Autowired
    YoutubeMapper youtubeMapper;
    @Autowired
    MusicMapper musicMapper;
    @Autowired
    HistoryMapper historyMapper;

    @Autowired
    WishService wishService;
    @GetMapping("info")
    public String info(){
        WelcomeDto welcomeDto=new WelcomeDto();
        Example example=new Example(Wish.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("status",0);
        Example example1=new Example(Youtube.class);
        Example.Criteria criteria1=example.createCriteria();
        criteria.andEqualTo("status",0);
        Example example2=new Example(History.class);
        Example.Criteria criteria2=example.createCriteria();
        criteria.andEqualTo("status",0);
        Example example3=new Example(Music.class);
        Example.Criteria criteria3=example.createCriteria();
        criteria.andEqualTo("status",0);
        int wishCount=wishMapper.selectCountByExample(example);
        int youtubeCount=youtubeMapper.selectCountByExample(example1);
        int historyCount=historyMapper.selectCountByExample(example2);
        int musicCount=musicMapper.selectCountByExample(example3);
        welcomeDto.setHistoryCount(historyCount);
        welcomeDto.setMusicCount(musicCount);
        welcomeDto.setYoutubeCount(youtubeCount);
        welcomeDto.setWishCount(wishCount);
        welcomeDto.setData(wishService.findTop().toArray());
        return JSON.toJSONString(welcomeDto);
    }

}
