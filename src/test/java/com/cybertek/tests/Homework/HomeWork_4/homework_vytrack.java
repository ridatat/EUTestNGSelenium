package com.cybertek.tests.Homework.HomeWork_4;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.PersonelInfoPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class homework_vytrack extends TestBase {
    // Test Data
    // Env : QA1
    //storemanager85
    //UserUser123

    @Test
    public void test1(){
        extentLogger = report.createTest("Test Case 1 - Page Subtitle Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.login("storemanager85","UserUser123");
        extentLogger.info("Navigate to Activities -> Calendar Events Page");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Verify that page subtitle 'Options' is displayed");
        Assert.assertEquals(calendarEventsPage.optionsDropDown.getText(),"Options","Verify Options");
        extentLogger.pass("PASSED");

    }

    @Test
    public void test2(){
        extentLogger = report.createTest("Test 2 - Page number is 1");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Go to Activities -> Calendar Events Page");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        extentLogger.info("Verify that page number is 1");
        BrowserUtils.waitFor(8);
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1","Verify that page number is 1");
        extentLogger.pass("PASSED");
    }
    @Test
    public void test3(){
        extentLogger = report.createTest("Test Case 3 - Per Page Number Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoreManager();
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Go to Activities -> Calendar Events page");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentLogger.info("Verify that per page number is 25");
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(),"25","Verify that view per page is 25");
        extentLogger.pass("PASSED");
    }

   @Test
    public void test5(){
       extentLogger = report.createTest("Test Case 3 - Per Page Number Verification");
       LoginPage loginPage = new LoginPage();
       extentLogger.info("Login as a store manager");
       loginPage.loginAsStoreManager();
       DashboardPage dashboardPage = new DashboardPage();
       extentLogger.info("Go to Activities -> Calendar Events page");
       dashboardPage.navigateToModule("Activities","Calendar Events");
       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       BrowserUtils.waitForClickablility(calendarEventsPage.allCheckbox,15);
       calendarEventsPage.allCheckbox.click();
      // int counter=0;
       BrowserUtils.waitForPageToLoad(5);
       int sayac=0;
       for (int i = 0; i < calendarEventsPage.eachCheckbox.size(); i++) {
                if(calendarEventsPage.eachCheckbox.get(i).isSelected()){
                    sayac++;
                }
       }
       /*
       for (WebElement each : calendarEventsPage.eachCheckbox ) {
           if (each.isSelected()){
               counter++;
           }
       }
       */
       Assert.assertEquals(sayac,25);
   }

   @DataProvider
   public Object [] [] meetingData(){
       ExcelUtil info = new ExcelUtil("src/test/resources/homework_vytack.xlsx","Sheet1");
       String [][] dataArray= info.getDataArrayWithoutFirstRow();
       return dataArray;
   }
   @Test(dataProvider = "meetingData")
    public void test6(String title,String testersMeeting){
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.titleTableSet("Testers meeting").click();
        PersonelInfoPage personelInfoPage = new PersonelInfoPage();
        

       String actualResult=personelInfoPage.getDescripton();
       String expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

/*
       actualResult=personelInfoPage.getStart();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getEnd();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getAllday();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getOrganizer();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getGuest();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getRecurrence();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

       actualResult=personelInfoPage.getCall();
       expectedResult=title+testersMeeting;
       Assert.assertEquals(actualResult,expectedResult);

*/
   }





}
