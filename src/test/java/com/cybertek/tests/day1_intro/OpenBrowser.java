package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        //we have to enter this line every time we want to open chrome
        //hey webdrivemanageer, can you make chore ready for me for automation
        WebDriverManager.chromedriver().setup();

        //WebDriver represent the browser
        //We are creating driver for chrome browser
        //new ChromeDriver() --> this part will open  chrome browser
        WebDriver driver = new ChromeDriver();

        //.get(URL) method used for navigate to what we want
        driver.get("https://cybertekschool.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://google.com");

    }
}
