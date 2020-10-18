package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        //make browser fullscreen
        driver.manage().window().maximize();

        WebElement fullnameInput= driver.findElement(By.name("full_name"));
        fullnameInput.sendKeys("Mike Smith");

        //put some email and click sign-up button
        //proper way
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("ridatat@gmail.com");

        //lazy way
        //driver.findElement(By.name("email")).sendKeys("ridatat@gmail.com");

        WebElement signUpBox = driver.findElement(By.name("wooden_spoon"));
        signUpBox.click();

        driver.quit();






    }
}
