package com.lau.spider.youtube;

import com.lau.spider.command.LinuxCommand;
import com.lau.spider.mapper.YoutubeMapper;
import com.lau.spider.model.Youtube;
import com.lau.spider.redis.RedisService;
import com.lau.spider.redis.SpiderKey;
import com.lau.spider.service.YoutubeService;
import com.lau.spider.util.MyWebDriver;
import com.lau.spider.util.Spider;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: yyoutube获取视频连接
 * @Param:
 * @return:
 * @Author:Lau52y
 * @Date: 2018/8/10
 */
@RestController
@RequestMapping("/youtube")
public class YouTobeSpider {

    private static final Logger log = LoggerFactory.getLogger(YouTobeSpider.class);

    //创建两个浏览器对象
    //public static WebDriver driver = MyWebDriver.createWebDriver();

    @Autowired
    YoutubeService youtubeService;

    @Autowired
    RedisService redisService;

    private final static String TARGET_URL = "https://www.youtube.com/channel/UCT4layPPCzgR_99g5VYYvmQ/videos?flow=grid&view=0&sort=p";
    public static final String RESOLVE_URL = "https://qdownloader.net/download?video=";

    @RequestMapping("getList")
    public String run(@RequestParam("url") String url) throws InterruptedException {
        WebDriver driver = MyWebDriver.createWebDriver();
        driver.get(url);
        //获取页面上所有的a标签链接
        List<WebElement>alist=driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
        if (alist.size() > 0) {

            alist.forEach(aelement -> {
                int j=1;
                int i = 600;
                String href = aelement.getAttribute("href");
                String videoId = href.substring(href.lastIndexOf("=") + 1, href.length());
                String isvideo=redisService.get(SpiderKey.getYouToBeKey,videoId,String.class);
                if (StringUtils.isEmpty(isvideo)){
                    //如果符合视频链接条件就存进数据库和redis,然后继续打开该连接页面提取连接
                    String title = aelement.getText();
                    System.out.println(title + "======================" + href);
                    Youtube youtube = new Youtube();
                    youtube.setName(title);
                    youtube.setUrl(href);
                    youtube.setVideoid(videoId);
                    youtubeService.insertYoutuBe(youtube);
                    redisService.set(SpiderKey.getYouToBeKey, videoId, href);
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, "+i+")");
                    System.out.println(j);

                }
                j++;
                i++;
            });
        }
        Thread.sleep(3000);
        //driver.quit();
        return "Get the video connection is complete!";

    }

    @RequestMapping("ssh")
    public String text(){
        try {
            LinuxCommand.runCmd("ifconfig", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sss";
    }

   /*public static void main(String[] args) {

        try {
            new YouTobeSpider().run("https://www.youtube.com/channel/UCT4layPPCzgR_99g5VYYvmQ/videos?flow=grid&view=0&sort=p");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        *//*String url="https://www.youtube.com/watch?v=RsVpYDk-XEg";
        System.out.println(url.substring(url.lastIndexOf("=")+1,url.length()));*//*


    }*/

    /*public static String getVideoId(String url){

        int videoIdLenght=url.length()-url.lastIndexOf("=")-1;
        if (videoIdLenght==11){
            String videoId=url.substring(url.lastIndexOf("=")+1,url.length());
            return videoId;
        }
        return url+"该链接不是视频链接";
    }*/




}
