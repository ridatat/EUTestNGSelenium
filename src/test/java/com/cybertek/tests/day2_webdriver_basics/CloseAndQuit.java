package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(3000);

        //close current tab
        driver.close();

        //giving new browser tab
        driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        Thread.sleep(5000);
        driver.close();

        Thread.sleep(6000);
        //closes all tabs
        driver.quit();
    }
}