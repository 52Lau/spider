package com.lau.spider;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lau.spider.command.LinuxCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.lau.spider.mapper")
public class SpiderApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(SpiderApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            //LinuxCommand.versouSshUtil("113.52.135.185", "root", "Lxy@15576771990", 462);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("服务启动完成!");
    }


    @RequestMapping("/")
   public String home() {
        return "redirect:index";
    }
}

