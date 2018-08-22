package com.lau.spider.controller;

import cn.hutool.crypto.SecureUtil;

import com.lau.spider.model.User;
import com.lau.spider.model.dto.HaloConst;
import com.lau.spider.model.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    /*@Autowired
    UserService userService;*/

    /**
     * 頁面跳轉，沒有登录則需重新登录
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/drop/{page}")
    public String path(@PathVariable("page") String page, HttpSession session) {
        User user = (User) session.getAttribute("user_session");
        if (null != user) {
            return "/user/" + page;
        }
        return "user/login";
    }

    @PostMapping(value = "/getLogin")
    @ResponseBody
    public JsonResult getLogin(@ModelAttribute("loginEmail") String loginEmail,
                               @ModelAttribute("loginPwd") String loginPwd,
                               HttpSession session) {
        //User user = userService.login(loginEmail, SecureUtil.md5(loginPwd));
        User user=new User();
        user.setUserName("00000");
        if (user != null) {
            session.setAttribute(HaloConst.USER_SESSION_KEY, user);
            //重置用户的登录状态为正常
            return new JsonResult(1, "登录成功！");
        }
        return new JsonResult(0, "登录失败，檢查你的輸入");
    }

    /**
     * 处理跳转到登录页的请求
     *
     * @param session session
     * @return 模板路径user/login
     */
    @GetMapping(value = "/login")
    public String login(HttpSession session) {
        User user = (User) session.getAttribute("user_session");
        //如果session存在，跳转到后台首页
        if (null != user) {
            return "redirect:/admin";
        }
        return "user/login";
    }

    /**
     * 跳转模板页面user/index
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping(value = {"", "/index"})
    public String index(Model model, HttpSession session) {

        model.addAttribute("mediaCount", HaloConst.ATTACHMENTS.size());
        return "user/index";
    }


    /**
     * 退出登录 销毁session
     *
     * @param session session
     * @return 重定向到/user/login
     */
    @GetMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        User user = (User) session.getAttribute(HaloConst.USER_SESSION_KEY);
        session.invalidate();
        log.info("用户[" + user.getUserName() + "]退出登录");
        return "redirect:/user/login";
    }


}
