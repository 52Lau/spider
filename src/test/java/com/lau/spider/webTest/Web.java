package com.lau.spider.webTest;

import com.lau.spider.util.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Web {
    public static void main(String[] args) throws Exception{
        WebDriver driver = MyWebDriver.createWebDriver();
        try {
            driver.get("https://om.qq.com/userAuth/index");
            Thread.sleep(3000);
            driver.findElement(By.className("login-type-qq")).click();
            Thread.sleep(3000);
            WebElement qqLoginDiv=driver.findElement(By.className("ptlogin-container"));
            Thread.sleep(3000);
            driver.switchTo().frame(qqLoginDiv.findElement(By.tagName("iframe")).getAttribute("id"));
            Thread.sleep(3000);
            driver.switchTo().frame(driver.findElement(By.id("ptlogin_iframe")).getAttribute("id"));
            Thread.sleep(3000);
            driver.findElement(By.id("switcher_plogin")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("u")).sendKeys("2449481757");
            driver.findElement(By.id("p")).sendKeys("cmn2000604");
            driver.findElement(By.id("login_button")).click();
            Thread.sleep(20000);

            driver.findElement(By.id("tcaptcha_drag_thumb"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //driver.close();
        }
    }

}
