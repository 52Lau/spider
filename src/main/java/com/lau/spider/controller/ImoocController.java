package com.lau.spider.controller;

import com.lau.spider.util.Message;
import com.lau.spider.webmagic.ImoocSpider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value="imooc")
public class ImoocController {


    @RequestMapping(value ="/update")
    @ResponseBody
    public Integer SpiderStart() {
        ImoocSpider.ImoocSpiderStart();
        return Message.fail;
    }
}
