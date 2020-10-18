package com.cybertek.tests.day8_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectedDropDownTest {
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
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));

        //2.Create select object by passing that element as a constructor
        Select stateDropdown= new Select(dropDownElement);


        //getOptions -->returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        //print of size of options
        System.out.println("options.size() = " + options.size());
        //print of each options
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any webelement with unique locator
        WebElement dropDownElement = driver.findElement(By.id("state"));




        //2.Create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropDownElement);

        //verify that first selection is 'Select a State'
        String expectedOption="Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");

        //HOW TO SELECT OPTİONS FROM DROPDOWN?
        //1.SELECT USİNG VİSİBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify firt seleted");

        //2.SELECT USİNG INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption="Wyoming";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify firt seleted");


        //3.SELECT USING VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TN");

        expectedOption="Tennessee";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify firt seleted");

    }

}
