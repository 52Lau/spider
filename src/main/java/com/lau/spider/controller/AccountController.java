package com.lau.spider.controller;

import com.alibaba.fastjson.JSON;
import com.lau.spider.dto.LayuiDto;
import com.lau.spider.model.Account;
import com.lau.spider.service.AccountService;
import com.lau.spider.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: MusicController
 * @description: 账号信息
 * @author: Lau52y
 * @create: 2018-08-12 21:41
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@RestController
@RequestMapping(value="account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "list",produces = "application/json; charset=utf-8")
    public String list(Account account, @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int limit){
        LayuiDto layuiDto = accountService.findPage(account,page,limit);
        return JSON.toJSONString(layuiDto);
    }

    @GetMapping(value = "/get/{id}",produces = "application/json; charset=utf-8")
    public ModelAndView get(@PathVariable("id") int id){
        ModelAndView result = new ModelAndView("account-edit2");
        Account account = accountService.selectByKey(id);
        result.addObject("account", account);
        return result;
    }
    @GetMapping(value = "/getById/{id}",produces = "application/json; charset=utf-8")
    public String getById(@PathVariable("id") int id){
        Account account = accountService.selectByKey(id);
        return JSON.toJSONString(account);
    }

    /**
     * 修改
     * @param jsonStr
     * @return
     */
    @PutMapping(value ="/update")
    @ResponseBody
    public Integer update(@RequestBody String jsonStr) {
        Account account = JSON.parseObject(jsonStr,Account.class);
        int count=accountService.updateNotNull(account);
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
        Account account = JSON.parseObject(jsonStr,Account.class);
        account.setStatus(1);
        int count=accountService.updateNotNull(account);
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



}
