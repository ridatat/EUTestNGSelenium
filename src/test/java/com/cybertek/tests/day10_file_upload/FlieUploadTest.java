package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FlieUploadTest {

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
    public void myComputerForAvailableUpload(){

        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button ---but not clicking
        WebElement chooseFileButton= driver.findElement(By.cssSelector("#file-upload"));

        //sending file with sendKeys method-- right click to folder than copy path!
        chooseFileButton.sendKeys("/Users/mac/Desktop/CYBERTEK_2020/Cybertek-Lecture | Schedule/13 Eylül-Day11_Test Automation Selenium/file.txt");

        driver.findElement(By.cssSelector("#file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"file.txt");


    }


    @Test
    public void allComputerForAvailableUpload(){

        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFileButton= driver.findElement(By.cssSelector("#file-upload"));
        //sending file with sendKeys method
        String projectPath= System.getProperty("user.dir");
        System.out.println(projectPath);
        String filePath="src/test/resources/textfile.txt";
        String fullPath= projectPath+"/"+filePath;
        chooseFileButton.sendKeys(fullPath);
        driver.findElement(By.cssSelector("#file-submit")).click();

        //getting the file name from browser
        String actualFileName= driver.findElement(By.id("uploaded-files")).getText();

        //verify file name is file.txt
        Assert.assertEquals(actualFileName,"textfile.txt");



    }
}
