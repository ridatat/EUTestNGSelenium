package com.cybertek.tests.Homework.HomeWork_2;

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
import java.util.concurrent.TimeUnit;

public class Until18EylülHomework {

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
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        String expectedResult="The date of birth is not valid";
        String actualResult = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Verify that warning message is displayed");
    }

    @Test
    public void test2(){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        WebElement languageBoxC = driver.findElement(By.xpath("//input[@value='cplusplus']"));
        Assert.assertTrue(languageBoxC.isDisplayed(),"Verify that displayed on the screen : C++");
        WebElement languageBoxJ = driver.findElement(By.xpath("//input[@value='java']"));
        Assert.assertTrue(languageBoxJ.isDisplayed(),"Verify that displayed on the screen : Java");
        WebElement languageBoxJS = driver.findElement(By.xpath("//input[@value='javascript']"));
        Assert.assertTrue(languageBoxJS.isDisplayed(),"Verify that displayed on the screen : JavaScript");


 //       List<WebElement> languageCheckedBox = driver.findElements(By.xpath("//input[@class='form-check-input']"));
 //       System.out.println("languageCheckedBox.size() = " + languageCheckedBox.size());

//        for (int i = 0; i < languageCheckedBox.size(); i++) {

 //           Assert.assertTrue(languageCheckedBox.get(i).isDisplayed(),"Verify that p.l are displayed: c++, java, JavaScript ");

    }

    @Test
    public void test3(){

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        nameBox.sendKeys("R");
        WebElement warningMsg= driver.findElement(By.xpath("//small[@data-bv-result='INVALID'][@data-bv-for='firstname']"));
        String actualR = warningMsg.getText();
        String expectedR="first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualR,expectedR,"Verify that warning message is displayed:");

    }

    @Test
    public void test4(){

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("T");
        String actualR = driver.findElement(By.xpath("//small[@data-bv-result='INVALID'][@data-bv-for='lastname']")).getText();

        String expectedR="The last name must be more than 2 and less than 64 characters long";
       // Assert.assertEquals(actualR,expectedR,"Verify that warning message is displayed:");

        WebElement errorMsg=driver.findElement(By.xpath("//small[@data-bv-result='INVALID'][@data-bv-for='lastname']"));
        Assert.assertTrue(errorMsg.getText().contains("The last name must be more than 2 and less than 64 characters long"));


    }


    @Test
    public void test5() throws InterruptedException {

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        nameBox.sendKeys("Rida");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Tatlici");
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Ralfrida");
        driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("ridatat@gmail.com");
        driver.findElement(By.xpath("//input[@data-bv-field='password']")).sendKeys("Rida:6608");
        driver.findElement(By.xpath("//input[@placeholder='571-000-0000']")).sendKeys("332-582-8385");
        List<WebElement> selectedSituationGender = driver.findElements(By.xpath("//input[@name='gender']"));
        for (int i = 0; i < selectedSituationGender.size(); i++) {
            System.out.println(i+"selectedSituation = " + selectedSituationGender.get(i).isSelected());

        }

        selectedSituationGender.get(0).click();
        driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("05/12/1992");
        WebElement department= driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentDropDown = new Select(department);
        departmentDropDown.selectByValue("DE");

        WebElement jobTitle= driver.findElement(By.name("job_title"));
        Select jobTitleDropDown = new Select(jobTitle);
        jobTitleDropDown.selectByVisibleText("SDET");

 //       List<WebElement> selectedSituationLanguage = driver.findElements(By.cssSelector(".form-check-label"));
 //       for (int i = 0; i < selectedSituationLanguage.size(); i++) {
 //           System.out.println(i+"selectedSituationLanguage = " + selectedSituationLanguage.get(i).isSelected());
 //       }
 //       selectedSituationLanguage.get(0).click();
 //       for (int i = 0; i < selectedSituationLanguage.size(); i++) {
 //           if(selectedSituationLanguage.get(i).isSelected()){
 //               selectedSituationLanguage.get(i).click();
 //           }
 //       }

        List<WebElement> selectedSituationLanguage = driver.findElements(By.cssSelector(".form-check-label"));
        for (WebElement webElement : selectedSituationLanguage) {
            System.out.println("webElement.isSelected() = " + webElement.isSelected());
            webElement.click();
        }
        Thread.sleep(1000);
        for (WebElement webElement : selectedSituationLanguage) {
            System.out.println("webElement.isSelected() = " + webElement.isSelected());
            webElement.click();
        }
        Thread.sleep(1000);

        selectedSituationLanguage.get(1).click();
        WebElement signButton= driver.findElement(By.cssSelector("#wooden_spoon"));
        signButton.click();

        WebElement msg = driver.findElement(By.xpath("//div/p"));
        String actualR = msg.getText();
        String expectedR="You've successfully completed registration!";

        Assert.assertTrue(msg.getText().contains("You've successfully completed registration!"));

        //Assert.assertEquals(actualR,expectedR,"Verification different way");

    }

    @Test
    public void test6() throws InterruptedException {
        driver.navigate().to("https://www.tempmailaddress.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='color cetc']")).click();
        String email = driver.findElement(By.xpath("//span[@id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Rida");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();

        WebElement text= driver.findElement(By.xpath("//*[@*='signup_message']"));
        Assert.assertTrue(text.getText().contains("Thank you for signing up."));


        driver.get("https://www.tempmailaddress.com/");

        String expectedR=" do-not-reply@practice.cybertekschool.com";
        String actualR = driver.findElement(By.xpath("//td[@class='from']")).getText();
        Assert.assertEquals(actualR,expectedR);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//td[@class='from']")).click();
        String actualEmailFrom = driver.findElement(By.cssSelector("#odesilatel")).getText();
        String expectedEmailFrom="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmailFrom,expectedEmailFrom,"Verify that email came from ");

        String actualSubject = driver.findElement(By.cssSelector("#predmet")).getText();
        String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject,expectedSubject,"Verify that subjects");

    }

    @Test
    public void test7(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/mac/Desktop/CYBERTEK_2020/Cybertek-Lecture | Schedule/Homework Test Automotion /homework2.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();
        String expectedR="File Uploaded!";
        String actualR = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        Assert.assertEquals(actualR,expectedR,"Verify the msg 'File Uploaded!'");

        WebElement failName=driver.findElement(By.cssSelector("#uploaded-files"));
        //böyle yaptığımız herhangi bir msg ekran var mı yok mu yapıyoruz.
        Assert.assertTrue(failName.isDisplayed(),"Verify that uploaded name is displayed");

        Assert.assertTrue(failName.getText().contains("homework2"));

    }

    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@onclick='log()']")).click();

        WebElement msg = driver.findElement(By.cssSelector("#result"));

        Assert.assertTrue(msg.isDisplayed(),"Verify that msg is :“You selected: United States of America”");

    }

    @Test
    public void test9(){

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("200")).click();

        WebElement msg = driver.findElement(By.xpath("//div[@class='example']//p"));
        Assert.assertTrue(msg.getText().contains("This page returned a 200 status code."));

    }

    @Test
    public void test10() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("301")).click();
        WebElement msg= driver.findElement(By.xpath("//p[contains(text(),'This page returned a 301 status code.')]"));
        Assert.assertTrue(msg.getText().contains("This page returned a 301 status code."));

    }

    @Test
    public void test11(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("404")).click();
        WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 404 status code.')]"));
        Assert.assertTrue(msg.getText().contains("This page returned a 404 status code."));
    }

    @Test
    public void test12(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("500")).click();
        WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'This')]"));
        Assert.assertTrue(msg.getText().contains("This page returned a 500 status code."));


    }

}
