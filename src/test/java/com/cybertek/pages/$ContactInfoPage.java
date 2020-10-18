package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class $ContactInfoPage extends BasePage{
    public $ContactInfoPage()  {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement nameAndSurname;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement emailInfo;


}
