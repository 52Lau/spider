package com.lau.spider.webmagic.pipeline;

import com.lau.spider.mapper.ImoocMapper;
import com.lau.spider.model.Imooc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;
@Component //申明为spring组件
public class MyConsolePipeline implements Pipeline {

   @Autowired
    ImoocService imoocService;

    public MyConsolePipeline() {
    }
    // 静态初使化当前类
    private static  MyConsolePipeline myConsolePipeline;

    //注解@PostConstruct，这样方法就会在Bean初始化之后被Spring容器执行
    @PostConstruct
    public void init() {
        myConsolePipeline = this;
    }

    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        Iterator var3 = resultItems.getAll().entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry)var3.next();
            Imooc imooc=new Imooc();
            imooc.setTitle((String)entry.getValue());
            try {
                myConsolePipeline.imoocService.insert(imooc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println((String)entry.getKey() + ":\t" + entry.getValue());
        }

    }
}
