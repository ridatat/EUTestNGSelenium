package com.cybertek.tests.Homework.HomeWork_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Homework {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
      driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());

        WebElement checkBoxMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));
        Assert.assertFalse(checkBoxMessage.isDisplayed(),"Verify checkbox message is NOT displayed.");

        checkBox.click();
        System.out.println("checkBox.isSelected() = " + checkBox.isSelected());
        Assert.assertTrue(checkBoxMessage.isDisplayed(),"Verify checkbox message is  displayed.");


    }

    @Test
    public void test2(){

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkAllButton= driver.findElement(By.cssSelector("#check1"));
        String expectedText="Check All";
        String actualText = checkAllButton.getAttribute("value");
        Assert.assertEquals(actualText,expectedText,"Verify Check All button text is \"Check All \"");

        checkAllButton.click();

        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'element')]"));
        for (WebElement element : elements) {
            System.out.println("element.isSelected() = " + element.isSelected());
            Assert.assertTrue(element.isSelected(),"Verifiy All button is selected");

        }

        expectedText="Uncheck All";
        actualText=checkAllButton.getAttribute("value");
        Assert.assertEquals(actualText,expectedText,"Verify Check All button is changed Uncheck All");
    }

}
