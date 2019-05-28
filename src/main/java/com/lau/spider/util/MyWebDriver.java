package com.lau.spider.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deng on 2017/5/16.
 */
public class MyWebDriver {
    private final static String CHROME_DRIVER_PATH = "C:\\Users\\kaifa011\\Downloads\\chromedriver_win32\\chromedriver.exe";

    public static WebDriver createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        List<String> op = new ArrayList<String>();
        op.add("start-fullscreen");
        op.add("allow-running-insecure-content");
        op.add("--test-type");
        options.addArguments(op);

        ChromeOptions opiions=new ChromeOptions();
        opiions.addArguments("--start-maximized");

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver(opiions);
    }
}
