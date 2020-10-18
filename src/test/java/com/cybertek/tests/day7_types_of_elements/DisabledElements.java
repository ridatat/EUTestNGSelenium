package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void Test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn = driver.findElement(By.id("id"));

        //how to check any webelement is enabled or not ?
        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled(),"Verify green radio button is NOT enabled");

        greenRadioBtn.click();
        driver.quit();

    }
    @Test
    public void Test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox= driver.findElement(By.cssSelector("#input-example>input"));

        inputBox.sendKeys("some words");
    }
}
