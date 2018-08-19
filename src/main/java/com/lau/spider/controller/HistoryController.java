package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.History;
import com.lau.spider.service.HistoryService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: MusicController
 * @description: 历史
 * @author: Lau52y
 * @create: 2018-08-12 21:41
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(History history, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = historyService.findPage(history,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("history-edit2");
        History history = historyService.selectByKey(id);
        result.addObject("history", history);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        History history = historyService.selectByKey(id);
        return JSON.toJSONString(history);
    }

    /**
     * 修改  发布
     * @param jsonStr
     * @return
     */
    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        History history = JSON.parseObject(jsonStr,History.class);
        history.setIssend(0);
        int count=historyService.updateNotNull(history);
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
        History history = JSON.parseObject(jsonStr,History.class);
        history.setStatus(1);
        int count=historyService.updateNotNull(history);
        if (count>0){
            return Message.success;
        }
        return Message.fail;
    }




}
