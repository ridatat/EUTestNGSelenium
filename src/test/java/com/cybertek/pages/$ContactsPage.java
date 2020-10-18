package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class $ContactsPage extends BasePage{

    public $ContactsPage()  {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//td[@data-column-label='Email']")
    public List<WebElement> email;

    public WebElement getEmailInfo(String str){

        WebElement focus = null;

        for (int i = 0; i < email.size(); i++) {
            if (email.get(i).getText().contains(str)) {
                 focus = email.get(i);
            }
        }
        return focus;
    }


}
