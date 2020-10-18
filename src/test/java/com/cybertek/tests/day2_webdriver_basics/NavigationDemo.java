package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //navigate to another website with different selenuium method
        driver.navigate().to("https://www.facebook.com");

        //After navigate google wait 3 seconds and than ...
        Thread.sleep(3000);

        //goes back to previous page
        driver.navigate().back();

        Thread.sleep(3000);

        //goes forward after to back (where its come from)
        driver.navigate().forward();

        //refresh to webpage
        driver.navigate().refresh();
    }
}
