package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    //**
    // TASK
    //go to amazon.com
    //search for selenium
    //click search button
    //verify 1-48 of 304 result for "selenium"
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.xpath("(//input[@class='nav-input'])[1]"));
        searchBox.sendKeys("Java");
        Thread.sleep(3000);
        WebElement findButton=driver.findElement(By.xpath("//input[@value='Go']"));
        findButton.click();
        String expectedResult="1-48 of over 5,000 result for \"Java\"";
        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = result.getText();
        if(expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        driver.quit();
    }
}
