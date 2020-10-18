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
import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod  //each test case automatically use
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod  ////each test case automatically use
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
    @Test
    public void hover() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor
        Actions actions = new Actions(driver);

        //perform() --> perform the action , complete the action
        //moveToelement -->move your mouse to webelement (hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"Verify view link is displayed");



    }

    @Test
    public void dragAnddrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(3000);
        actions.dragAndDrop(source,target).perform();

        WebElement Message= driver.findElement(By.xpath("//div[text()='You did great!']"));
        String actualMessage = Message.getText();
        String expectedMessage="You did great!";

        Assert.assertEquals(actualMessage,expectedMessage);





    }

    @Test
    public void JamalWay() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(3000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));



        actions.dragAndDrop(source,target).perform();



    }

    @Test
    public void DifferentWay() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(3000);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }


}
