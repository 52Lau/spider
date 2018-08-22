package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Wish;
import com.lau.spider.service.WishService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @program: WishController
 * @description: 需求管理
 * @author: Lau52y
 * @create: 2018-08-12 21:41
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="wish")
public class WishController {

    @Autowired
    WishService wishService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(Wish wish, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = wishService.findPage(wish,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("wish-edit2");
        Wish wish = wishService.selectByKey(id);
        result.addObject("wish", wish);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        Wish wish = wishService.selectByKey(id);
        return JSON.toJSONString(wish);
    }


    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        Wish wish = JSON.parseObject(jsonStr,Wish.class);
        //wish.setCreatedate(new Date());
        wish.setIscomplete(0);
        int count=wishService.updateNotNull(wish);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }

    @PutMapping(value ="/insert")
    @ResponseBody
    public Integer insert(@RequestBody String jsonStr) {
        Wish wish = JSON.parseObject(jsonStr,Wish.class);
        int count=wishService.insert(wish);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }

    @DeleteMapping(value ="/update")
    @ResponseBody
    public Integer delete(@RequestBody String jsonStr) {
        Wish wish = JSON.parseObject(jsonStr,Wish.class);
        wish.setStatus(1);
        int count=wishService.updateNotNull(wish);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }




}
