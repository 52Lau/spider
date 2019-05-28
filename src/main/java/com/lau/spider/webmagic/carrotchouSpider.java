package com.lau.spider.webmagic;

import com.lau.spider.webmagic.pipeline.MyConsolePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class carrotchouSpider implements PageProcessor {

    static List<String> urlList=new ArrayList<>();

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("title", page.getHtml().xpath("body > section > div.content-wrap > div > article.excerpt.excerpt-1.excerpt-sticky > header > h2 > a").toString());
        if (page.getResultItems().get("title") == null) {
            //skip this page
            page.setSkip(true);
        }

        // 部分三：从页面发现后续的url地址来抓取
        // 非标准的url
        /*List<String> urlList=page.getHtml().links().regex("(/class/([0-9][0-9]*).html)").all();*/
        /*List<String> relUrlList=new ArrayList<>();
        for (String str : urlList) {
            relUrlList.add("https://coding.imooc.com"+str);
        }*/
        page.addTargetRequests(urlList);
    }


    @Override
    public Site getSite() {
        return site;
    }


    public static void ImoocSpiderStart(){
        DecimalFormat format = new DecimalFormat("000");
        for (int i = 0; i < 99; i++) {
            urlList.add("www.carrotchou.blog/page/"+i);
        }
        Spider.create(new carrotchouSpider())
                //从"https://github.com/code4craft"开始抓
                .addUrl("www.carrotchou.blog/page/1")
                .addPipeline(new MyConsolePipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();

    }

    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("000");
        for (int i = 0; i < 99; i++) {
            urlList.add("www.carrotchou.blog/page/"+i);
        }
        Spider.create(new carrotchouSpider())
                //从"https://github.com/code4craft"开始抓
                .addUrl("www.carrotchou.blog/page/1")
                .addPipeline(new MyConsolePipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();

    }
}
