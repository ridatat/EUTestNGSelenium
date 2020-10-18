package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class instagramAuto {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/");

        WebElement emailBox= driver.findElement(By.name("email"));
        emailBox.sendKeys("ridatatlici");

        Thread.sleep(3000);

        WebElement passwordBox=driver.findElement(By.name("pass"));
        passwordBox.sendKeys("43603639048rt");

        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        //ı want to open new tab but ı didnt find!
        WebDriver driver1=WebDriverFactory.getDriver("chrome");
        driver1.get("https://google.com");

        Thread.sleep(10000);


        driver.quit();




    }

}
