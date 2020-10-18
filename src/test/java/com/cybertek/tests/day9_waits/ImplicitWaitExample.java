package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod  //each test case automatically use
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod  ////each test case automatically use
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //bunu istediğimiz yere koyabilir her arattığımız da çalışır.
        WebElement element=driver.findElement(By.cssSelector("#finish"));
        System.out.println(element.getText());

    }
}
