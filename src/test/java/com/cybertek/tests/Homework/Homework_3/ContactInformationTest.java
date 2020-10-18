package com.cybertek.tests.Homework.Homework_3;

import com.cybertek.pages.$ContactInfoPage;
import com.cybertek.pages.$ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.$LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactInformationTest extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactTestNameSurname(){

        extentLogger = report.createTest("Contact Information Name&Surname");
        $LoginPage loginPage = new $LoginPage();
        loginPage.login("salesmanager");
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Hover over the Customers tab , go to Contact option and click");
        BrowserUtils.waitForPageToLoad(8);
        dashboardPage.navigateToModule("Customers","Contacts");
        $ContactsPage contactsPage = new $ContactsPage();
        BrowserUtils.waitFor(6);
        extentLogger.info("Go to 'mbrackstone9@example.com' email addressa and click");
        contactsPage.getEmailInfo("mbrackstone9@example.com").click();
        $ContactInfoPage contactPersonelPage = new $ContactInfoPage();
        String actual=contactPersonelPage.nameAndSurname.getText();
        String expected="Mariam Brackstone";
        extentLogger.info("Verify the name and surname");
        Assert.assertEquals(actual,expected,"Verify name and surname");
        extentLogger.pass("Passed ");

    }
    @Test
    public void contactTestMail(){

        extentLogger = report.createTest("Contact Information Mail");
        $LoginPage loginPage = new $LoginPage();
        loginPage.login("salesmanager");
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Hover over the Customers tab , go to Contact option and click");
        BrowserUtils.waitForPageToLoad(8);
        dashboardPage.navigateToModule("Customers","Contacts");
        $ContactsPage contactsPage = new $ContactsPage();
        BrowserUtils.waitFor(6);
        extentLogger.info("Go to 'mbrackstone9@example.com' email addressa and click");
        contactsPage.getEmailInfo("mbrackstone9@example.com").click();
        $ContactInfoPage contactPersonelPage = new $ContactInfoPage();
        String actual=contactPersonelPage.nameAndSurname.getText();
        String expected="Mariam Brackstone";
        actual=contactPersonelPage.emailInfo.getText();
        expected="m@example.com";
        extentLogger.info("Verify the email");
        Assert.assertEquals(actual,expected,"Verify email ");
        extentLogger.pass("Passed");

    }
    @Test
    public void contactTestPhone(){

        extentLogger = report.createTest("Contact Information Phone");
        $LoginPage loginPage = new $LoginPage();
        loginPage.login("salesmanager");
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Hover over the Customers tab , go to Contact option and click");
        BrowserUtils.waitForPageToLoad(8);
        dashboardPage.navigateToModule("Customers","Contacts");
        $ContactsPage contactsPage = new $ContactsPage();
        BrowserUtils.waitFor(6);
        extentLogger.info("Go to 'mbrackstone9@example.com' email addressa and click");
        contactsPage.getEmailInfo("mbrackstone9@example.com").click();
        $ContactInfoPage contactPersonelPage = new $ContactInfoPage();
        String actual=contactPersonelPage.phoneNumber.getText();
        String expected="+18982323434";
        extentLogger.info("Verify the phone number");
        Assert.assertEquals(actual,expected,"Verify phone number");
        extentLogger.pass("Passed");
    }

    @Test
    public void testtt(){
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
