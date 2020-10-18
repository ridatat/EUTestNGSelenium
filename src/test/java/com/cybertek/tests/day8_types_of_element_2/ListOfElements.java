package com.cybertek.tests.day8_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod  //each test case automatically use
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod  ////each test case automatically use
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(),6);

        //iter + hit enter to get each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }

        for (WebElement button : buttons) {
            System.out.println(button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"Verify buttons are displayed");
        }

        //click second button
        buttons.get(1).click();

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //driver.findElement(By.tagName("buttonbkbkbkbk"));
        List<WebElement> buttons = driver.findElements(By.tagName("buttonbkbkbkbk"));
        System.out.println("buttons.size() = " + buttons.size());


    }


}
