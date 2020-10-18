package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.$LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");
        $LoginPage loginPage = new $LoginPage();
        extentLogger.info("Login with valid credential ");
        loginPage.login("salesmanager");
        extentLogger.info("Navigate to --> Customers > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on \"mbrackstone9@example.com\" ");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        extentLogger.info("Verify full name: Mariam Brackstone");
        Assert.assertEquals(contactInfoPage.fullname.getText(),"Mariam Brackstone","Verify Full name");
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");
        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phonenumber.getText(),"+18982323434","Verify phone number");

        extentLogger.pass("PASSED");




















    }


}
