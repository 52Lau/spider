package com.lau.spider.controller;

import com.lau.spider.model.User;
import com.lau.spider.model.dto.HaloConst;
import com.lau.spider.model.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @program: PageController
 * @description: 页面跳转
 * @author: Lau52y
 * @create: 2018-08-12 22:12
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Slf4j
@Controller
@RequestMapping
public class PageController {

    /**
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String path(@PathVariable("page") String page, HttpSession session) {
        User user = (User) session.getAttribute("user_session");
        if (null != user) {
            return page;
        }
        return "login";
    }

    /**
     * 登录
     * @param loginEmail
     * @param loginPwd
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public JsonResult getLogin(@ModelAttribute("loginEmail") String loginEmail,
                               @ModelAttribute("loginPwd") String loginPwd,
                               HttpSession session) {
        //User user = userService.login(loginEmail, SecureUtil.md5(loginPwd));
        if (StringUtils.isNotEmpty(loginEmail)&&StringUtils.isNotEmpty(loginPwd)){
            if ("lifeng".equals(loginEmail) || "lau52y".equals(loginEmail)){
                if ("123456".equals(loginPwd)||"seeyouagain".equals(loginPwd)){
                    User user=new User();
                    user.setUserName("人生可否变作漫长浪漫程序");
                    if (user != null) {
                        session.setAttribute(HaloConst.USER_SESSION_KEY, user);
                        //重置用户的登录状态为正常
                        return new JsonResult(1, "登录成功！");
                    }
                }
            }
        }
        return new JsonResult(0, "登录失败，檢查你的輸入");
    }

}
