package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion-test1");
        Assert.assertEquals("title","titLe");

        System.out.println("Second Assertion-test1");
        Assert.assertEquals("url","url");

        //close
    }


    @Test
    public void test2(){
        System.out.println("First Assertion-test2");
        Assert.assertEquals("Google","Google","Verify test2");
    }

    @Test
    public void test3(){
        String expectedTitle="Cb";
        String actualTitle="Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");

    }

    @Test
    public void test4(){
        //verify email contains @ sign
        String email="mike@smith.com";
        Assert.assertTrue(email.contains("@"),"Verify email contains @");

    }

    @Test
    public void test5(){

        Assert.assertFalse(0>1,"Verify that 0 is not grather than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","one");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("Close browser");
    }
}
