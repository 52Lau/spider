package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Music;
import com.lau.spider.service.MusicService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping(value="music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(Music music, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = musicService.findPage(music,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("music-edit2");
        Music music = musicService.selectByKey(id);
        result.addObject("music", music);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        Music music = musicService.selectByKey(id);
        return JSON.toJSONString(music);
    }


    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        Music music = JSON.parseObject(jsonStr,Music.class);
        int count=musicService.updateNotNull(music);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }

    @DeleteMapping(value ="/update")
    @ResponseBody
    public Integer delete(@RequestBody String jsonStr) {
        Music music = JSON.parseObject(jsonStr,Music.class);
        music.setStatus(1);
        int count=musicService.updateNotNull(music);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }




}
