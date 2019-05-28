package com.lau.spider.webmagic.pipeline;

import cn.hutool.http.HttpUtil;
import com.lau.spider.webmagic.dto.FTsopan;
import org.openqa.selenium.NoSuchElementException;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.lau.spider.util.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ImoocPipeline implements Pipeline {

    static WebDriver driver = MyWebDriver.createWebDriver();

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }

    /**
     *
     * @param driver
     * @param content 内容
     * @param type 类型 xpath select classname
     * @return
     */
    public static boolean IsContentAppeared(WebDriver driver,String content,Integer type) {
    boolean status = false;
    try {
        if (type==1){
            driver.findElement(By.className(content));
            System.out.println("按照className匹配内容："+content+" true");
        }else if(type==2){
            driver.findElement(By.id(content));
            System.out.println("按照id匹配内容："+content+" true");
        }else if(type==3){
            driver.findElement(By.name(content));
            System.out.println("按照name匹配内容："+content+" true");
        }else{
            driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));
            System.out.println("按照字符匹配内容："+content+" true");
        }
        status=true;
    } catch (NoSuchElementException e){
        status = false;
        System.out.println("'" + content + "' doesn't exist!");
    }
    return status;
    }
    /*逐个获取所有网站的资源
    ["https://www.aisouziyuan.com/", "爱搜资源", [
             ["", "https://www.aisouziyuan.com/?name=%sv%", "get", ],
          ], ]*/
    private static  void Aisouziyuan(String title) throws Exception{
        // https://www.aisouziyuan.com/?name=逆光飞翔
        // 只获取第一页的
        driver.get("https://www.aisouziyuan.com/?name="+title+"&page=1&sort=0&isPrecise=0");
        //可以以此判定是否有搜索结果  :
        if (IsContentAppeared(driver,"点击加载更多",99)||IsContentAppeared(driver,"排序",99)){
            List<WebElement> liList=driver.findElement(By.className("main")).findElements(By.tagName("li"));
            // h获取当前打开的主窗口
            String current_window = driver.getWindowHandle();

            for (WebElement li: liList) {
                // 路径
                li.findElement(By.tagName("a")).click();
                Thread.sleep(3000);
                // 密码
                String pwd="";
                if (IsContentAppeared(driver,"icon-key",1)){
                    try {
                        pwd=li.findElement(By.className("icon-key")).findElement(By.xpath("./following-sibling::span[1]")).getText();
                    } catch (Exception e) {
//                        System.out.println("pass");
                    }
                    //i/following-sibling::span[1]
//                    pwd=li.findElement(By.className("xh-highlight")).getText();
                }
                System.out.println("密码为："+pwd);

                //获取所有打开的窗口
                Set<String> handles = driver.getWindowHandles();
                // 切换到最新打开窗口
                //获取当前窗口浏览器地址
                String url="";
                for (String str : handles) {
                    if(!current_window.equals(str)){
                        driver.switchTo().window(str);
                        //已经被取消了
                        if (!IsContentAppeared(driver,"已经被取消了",99)){
                            url=driver.getCurrentUrl();
                        }
                        //关闭标签页
                        driver.close();
                    }
                }
                System.out.println(url);
                //切回默认的主窗口
                driver.switchTo().window(current_window);
                // 标题
                String name=li.findElement(By.tagName("a")).findElement(By.className("s-title")).findElement(By.tagName("span")).getText();
                // 时间
                String time=li.findElement(By.tagName("a")).findElement(By.className("node")).getText();

            }

        }else{
            System.out.println("没有获取到数据");
        }
    }

    /*["https://www.52sopan.com/", "我爱搜盘", [
            ["", "https://www.52sopan.com/s.php?keyword=%sv%", "get", ],
            ], ]*/
    private static void FTsopan(String title) throws Exception{
        //driver.get("https://www.aisouziyuan.com/?name="+title+"&page=1&sort=0&isPrecise=0");
        String json=HttpUtil.get("https://www.52sopan.com/search.php?mode=so&q=Jmeter&page_size=30&page_number=0");
        List<FTsopan>list=FTsopan.arrayFTsopanFromData(json);
        for (FTsopan f :
                list ) {
            System.out.println(f);

        }

    }

    /*["https://www.h2ero.com/", "闪电云", [
            ["", "https://www.h2ero.com/search?keywords=%sv%", "get", ],
            ], ]*/
    private  static void H2ero(String title) throws Exception{
        driver.get("https://www.h2ero.com/search?keywords="+title+"&page=1");
        List<WebElement> list=driver.findElements(By.className("topic-title"));
        Set<String> urlList = new TreeSet<>();
        String one_window = driver.getWindowHandle();
        for (WebElement element : list) {
            element.click();
            Thread.sleep(3000);
            //获取所有打开的窗口
            Set<String> handles = driver.getWindowHandles();
            //第二个窗口url
            String url="";
            String name="";
            String pwd="";
            for (String str : handles) {
                if(!one_window.equals(str)){
                    driver.switchTo().window(str);
                    //url1=driver.getCurrentUrl();
                    //获取信息 标题 密码
                    name =driver.findElement(By.className("topic-title")).getText();
                    pwd =driver.findElement(By.className("topic-content")).getText().replaceAll("前往百度网盘下载 密码:","");
                    //点击去百度页面
                    driver.findElement(By.className("topic-content")).click();
                    Thread.sleep(3000);
                    String two_window = driver.getWindowHandle();
                    Set<String> handlestwo = driver.getWindowHandles();
                    for (String str_tow : handlestwo) {
                        if (!str_tow.equals(two_window) && !str_tow.equals(one_window)){
                            driver.switchTo().window(str_tow);
                            //已经被取消了
                            if (!IsContentAppeared(driver,"已经被取消了",99)){
                                url=driver.getCurrentUrl();
                            }
                            //关闭标签页
                            driver.close();
                        }
                    }
                    //切回第二个窗口
                    driver.switchTo().window(two_window);
                    //获取该页面的推荐url
                    List<WebElement> elements = driver.findElement(By.className("related")).findElements(By.tagName("a"));
                    for (WebElement el:elements ) {
                        urlList.add(el.getAttribute("href"));
                    }
                    //关闭标签页
                    driver.close();
                }
            }
            System.out.println("name:"+name+"url:"+url+"pwd:"+pwd);
            //切回第一个窗口
            driver.switchTo().window(one_window);
        }
        for (String s : urlList) {
            String url="";
            String name="";
            String pwd="";
            driver.get(s);
            //获取信息 标题 密码
            name =driver.findElement(By.className("topic-title")).getText();
            pwd =driver.findElement(By.className("topic-content")).getText().replaceAll("前往百度网盘下载 密码:","");
            //点击去百度页面
            driver.findElement(By.className("topic-content")).click();
            Thread.sleep(3000);
            //String two_window = driver.getWindowHandle();
            Set<String> handlestwo = driver.getWindowHandles();
            for (String str_tow : handlestwo) {
                if (!str_tow.equals(one_window)){
                    driver.switchTo().window(str_tow);
                    //已经被取消了
                    if (!IsContentAppeared(driver,"已经被取消了",99)){
                        url=driver.getCurrentUrl();
                    }
                    //关闭标签页
                    driver.close();
                }
            }
            System.out.println("name:"+name+"url:"+url+"pwd:"+pwd);
            //切回第一个窗口
            driver.switchTo().window(one_window);
        }
    }

    /*["http://www.xiaobaipan.com/", "小白盘", [
         ["", "http://www.xiaobaipan.com/list-%sv%.html", "get", ],
      ], ]*/
    private static void Xiaobaipan(String title) throws  Exception{
        driver.get("http://www.xiaobaipan.com/list-"+title+".html");
        List<WebElement> els = driver.findElements(By.className("job-title"));
        List<WebElement>elements=new ArrayList<>();
        for (WebElement ele : els) {
            elements.add(ele.findElement(By.tagName("a")));
        }
        String one_window = driver.getWindowHandle();
        for (WebElement el:elements) {
            String name="";
            String pwd="";
            String url="";
            el.click();
            Thread.sleep(3000);
            Set<String> handles = driver.getWindowHandles();
            for (String str : handles) {
                //进入第二个窗口
                if (!str.equals(one_window)) {
                    driver.switchTo().window(str);
                    name=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[3]/div/div[1]/div/h1")).getText();
                    driver.findElement(By.id("btn-link")).findElement(By.tagName("a")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a")).click();
                    Thread.sleep(3000);
                    Set<String> handlestwo = driver.getWindowHandles();
                    for (String str_tow : handlestwo) {
                        //进入第三个窗口
                        if (!str_tow.equals(one_window)&& !str_tow.equals(str)) {
                            driver.switchTo().window(str_tow);
                            //已经被取消了
                            if (!IsContentAppeared(driver,"已经被取消了",99)){
                                url=driver.getCurrentUrl();
                            }
                            //关闭标签页
                            driver.close();
                        }
                    }
                    //关闭第二个
                    driver.switchTo().window(str);
                    driver.close();
                }
            }
            System.out.println("name:"+name+"url:"+url+"pwd:"+pwd);
            //切回第一个窗口
            driver.switchTo().window(one_window);
        }
    }
    /*["http://www.pansoso.com/", "盘搜搜", [
            ["", "http://www.pansoso.com/zh/%sv%", "get", ],
            ], ]*/
    private static  void Pansoso(String title) throws Exception{
        driver.get("http://www.pansoso.com/zh/"+title);
        List<WebElement> els = driver.findElements(By.className("pss"));
        List<WebElement>elements=new ArrayList<>();
        for (WebElement ele : els) {
            elements.add(ele.findElement(By.tagName("a")));
        }
        String one_window = driver.getWindowHandle();
        for (WebElement el:elements) {
            String name="";
            String pwd="";
            String url="";
            el.click();
            Thread.sleep(3000);
            Set<String> handles = driver.getWindowHandles();
            for (String str : handles) {
                //进入第二个窗口
                if (!str.equals(one_window)) {
                    driver.switchTo().window(str);
                    name=driver.findElement(By.xpath("//*[@id=\"con\"]/div/div[1]/h1")).getText();
                    driver.findElement(By.xpath("//*[@id=\"con\"]/div/div[2]/span[2]/a")).click();
                    Thread.sleep(3000);
                    Set<String> handlestwo = driver.getWindowHandles();
                    for (String str_tow : handlestwo) {
                        //进入第三个窗口
                        if (!str_tow.equals(one_window)&& !str_tow.equals(str)) {
                            driver.switchTo().window(str_tow);
                            pwd=driver.findElement(By.xpath("/html/body/div[2]/div[3]")).getText().replace("网盘列表：","").replace("百度网盘","").replace("提取码：","");
                            //点击跳转到百度
                            driver.findElement(By.className("btn-download")).click();
                            //等待
                            Thread.sleep(3000);
                            //已经被取消了
                            if (!IsContentAppeared(driver,"已经被取消了",99)){
                                url=driver.getCurrentUrl();
                            }
                            //关闭标签页
                            driver.close();
                        }
                    }
                    //关闭第二个
                    driver.switchTo().window(str);
                    driver.close();
                }
            }
            System.out.println("name:"+name+"url:"+url+"pwd:"+pwd);
            //切回第一个窗口
            driver.switchTo().window(one_window);
        }
    }


    public static void main(String[] args) throws  Exception{
        /*try {
            Aisouziyuan("海阔天空");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*FTsopan("海阔天空");*/
        /*H2ero("Spring Boot");*/
        /*Xiaobaipan("Spring Boot");*/
        Pansoso("App用组件方式开发全站");
    }


}
