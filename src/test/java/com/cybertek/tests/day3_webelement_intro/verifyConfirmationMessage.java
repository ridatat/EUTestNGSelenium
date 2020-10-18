package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {
        /*
        Verify confirmation message
        open browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says ‘Your e-mail’s been sent!’

         */

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the links
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail="ridatat@gmail.com";

        //sendKeys()-->send keyboard action to the webelement
        emailInputBox.sendKeys(expectedEmail);


        //somehow we should get text from webelement
        //two main ways to get txt from webelement
        //1.getText()-->it will work %99 and it will returning string
        //2.getAttribute("value")-->second way of getting txt especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input boxes
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }



        //click on retreive password button
        WebElement retreivedPasswordButton = driver.findElement(By.id("form_submit"));
        retreivedPasswordButton.click();



        //verify that confirmation message says ‘Your e-mail’s been sent!’

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        System.out.println(actualConfirmationMessage.getText());

        //save expected message
        String expectedMessage="Your e-mail’s been sent!";
        //save actual message to variable
        String actualMessage=actualConfirmationMessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close browser
        driver.quit();



    }
}
