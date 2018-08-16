package com.lau.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: PageController
 * @description: 页面跳转
 * @author: Lau52y
 * @create: 2018-08-12 22:12
 * <p>
 * <人生可否变作漫长浪漫程序！>
 **/
@Controller
public class PageController {

    /**
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String path(@PathVariable("page") String page) {
            return page;
    }
}
