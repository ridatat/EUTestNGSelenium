package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
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

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        //use common locator for the image
        List<WebElement> image = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));


        System.out.println("image.size() = " + image.size());
        Actions actions = new Actions(driver);

       for (int i = 0; i < image.size(); i++) {


                Thread.sleep(1000);
                actions.moveToElement(image.get(i)).perform();

                //verification part for each of them
                WebElement viewLink = driver.findElement(By.xpath("//h5[.='name: user"+(i+1)+"']"));
                Assert.assertTrue(viewLink.isDisplayed(),"Verify user" +(i+1) +" is displayed");
           }


        }

        //Jamal Ways
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {

            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user" + i + "']";
            WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(), "verify user " + i + " is displayed");

        }

    }

}



