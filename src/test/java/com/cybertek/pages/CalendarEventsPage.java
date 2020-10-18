package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@href='#']")
    public WebElement optionsDropDown;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/button[1]")
    public WebElement viewPerPage;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//div/button/input[@type='checkbox']")
    public WebElement allCheckbox;

    @FindBy(xpath = "//tr/td/input[@type='checkbox']")
    public List<WebElement> eachCheckbox;

    @FindBy(xpath = "//tr/td/input[@type='checkbox']")
    public List<WebElement> titleTable;

    public WebElement titleTableSet(String str){

        WebElement focus = null;
        for (WebElement title : titleTable) {

            if(title.getText().contains("Testers meeting")){
                focus=title;
            }
        }

        return focus;
    }






}