package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) {
        /*
        Verify URL changed
        -open browser
        -go to http://practice.cybertekschool.com/forgot_password Links to an -external site.
        enter any email
        -click on Retrieve password
        -verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to this webpage
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));

        //sendKeys()-->send keyboard action to the webelement
        emailInputBox.sendKeys("ridatat@gmail.com");


        //clikc retreived password button
        WebElement retreivedPasswordButton = driver.findElement(By.id("form_submit"));
        retreivedPasswordButton.click();


        //TASK
        //verify that url changed to http://practice.cybertekschool.com/email_sent

        //create expectedUrl
        String expectedUrl="http://practice.cybertekschool.com/email_sent";

        //save actual url after clicking
        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);
        }

        //close browser
        driver.quit();




    }
}
