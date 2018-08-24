package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Category;
import com.lau.spider.model.Content;
import com.lau.spider.model.User;
import com.lau.spider.service.CategoryService;
import com.lau.spider.service.ContentService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @program: ContentController
 * @description: 内容管理
 * @author: Lau52y
 * @create: 2018-08-21 22:03
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="content")
public class ContentController {

    @Autowired
    ContentService contentService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(Content content, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = contentService.findPage(content,page,limit);
        return JSON.toJSONString(layuiDto);
    }


    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("wish-add3");
        Content content = contentService.selectByKey(id);

        //动态select 回显
        Category category=new Category();
        category.setType(2);
        List<Category> categoryList = categoryService.typeList(category);
        result.addObject("content", content);
        result.addObject("categorys",categoryList);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        Content content = contentService.selectByKey(id);
        return JSON.toJSONString(content);
    }

    /**
     * 修改
     * @param jsonStr
     * @return
     */
    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        Content content = JSON.parseObject(jsonStr,Content.class);
        int count=contentService.updateNotNull(content);
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }

    /**
     * 禁用
     * @param jsonStr
     * @return
     */
    @DeleteMapping(value ="/update")
    @ResponseBody
    public Integer delete(@RequestBody String jsonStr) {
        Content content = JSON.parseObject(jsonStr,Content.class);
        content.setStatus(1);
        int count=contentService.updateNotNull(content);
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }


    @PutMapping(value ="/insert")
    @ResponseBody
    public Integer insert(@RequestBody String jsonStr) {
        Content content = JSON.parseObject(jsonStr,Content.class);
        content.setStatus(0);
        content.setCreatedate(new Date());
        int count=contentService.save(content);
        LayuiDto layuiDto=new LayuiDto();
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }


    /**
     * @param page
     * @return
     */
    @RequestMapping("/drop/{page}")
    public ModelAndView path(@PathVariable("page") String page, HttpSession session) {
        ModelAndView result = new ModelAndView("wish-add2");
        User user = (User) session.getAttribute("user_session");
        if (null != user) {
            //动态select 回显
            Category category=new Category();
            category.setType(2);
            List<Category> categoryList = categoryService.typeList(category);
            result.addObject("categorys",categoryList);
            return result;
        }

        return new ModelAndView("login");
    }

}
