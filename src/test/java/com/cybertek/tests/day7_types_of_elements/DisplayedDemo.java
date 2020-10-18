package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.cssSelector("#username"));

        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        //verify username inputbox is not displayed on the screen
        Assert.assertFalse(userNameInput.isDisplayed(),"Verify username input box is not displayed");

        //click on start button
       driver.findElement(By.cssSelector("#start>button")).click();
        //wait until elements displayed
        Thread.sleep(8000);
        userNameInput.click();

        //verify username displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed(),"Verify username input box is displayed");

        driver.quit();


    }

}
