package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Youtube;
import com.lau.spider.service.YoutubeService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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
@RequestMapping(value="youtube")
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(Youtube youtube, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = youtubeService.findPage(youtube,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("youtube-edit2");
        Youtube youtube = youtubeService.selectByKey(id);
        result.addObject("youtube", youtube);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        Youtube youtube = youtubeService.selectByKey(id);
        return JSON.toJSONString(youtube);
    }


    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        Youtube youtube = JSON.parseObject(jsonStr,Youtube.class);
        youtube.setCreatedate(new Date());
        int count=youtubeService.updateNotNull(youtube);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }

    @DeleteMapping(value ="/update")
    @ResponseBody
    public Integer delete(@RequestBody String jsonStr) {
        Youtube youtube = JSON.parseObject(jsonStr,Youtube.class);
        youtube.setStatus(1);
        int count=youtubeService.updateNotNull(youtube);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }




}
