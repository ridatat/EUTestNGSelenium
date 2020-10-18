package com.cybertek.pages;


import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonelInfoPage extends BasePage {

    public PersonelInfoPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//label[contains(text(),'Description')]")
    public WebElement description;
    @FindBy(xpath = "//span[contains(text(),'This is a a weekly testers meeting')]")
    public WebElement descriptionC;
    public String getDescripton(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(description, 5);
        return description.getText()+descriptionC.getText();
    }

    @FindBy(xpath = "//label[contains(text(),'Start')]")
    public WebElement start;
    @FindBy(xpath = "//div[contains(text(),'Nov 27, 2019, 9:30 PM')]")
    public WebElement startC;
    public String getStart(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(start, 5);
        return start.getText()+startC.getText();
    }

    @FindBy(xpath = "//label[contains(text(),'End')]")
    public WebElement end;
    @FindBy(xpath = "//div[contains(text(),'Nov 27, 2019, 10:30 PM')]")
    public WebElement endC;
    public String getEnd(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(end, 5);
        return end.getText()+endC.getText();
    }

    @FindBy(xpath = "//label[contains(text(),'All-day event')]")
    public WebElement alldayevent;
    @FindBy(css = "body.desktop-version.lang-en:nth-child(2) div.app-page:nth-child(2) div.app-page__content div.app-page__main div.app-page__central-panel div.scrollable-container:nth-child(3) div.layout-content:nth-child(2) div.layout-content.scrollable-container:nth-child(2) div.clearfix div.scrollspy.container-fluid.scrollable-container div.responsive-section.responsive-small:nth-child(1) div.section-content div.row-fluid div.form-horizontal div.responsive-cell div.row-fluid.form-horizontal div.responsive-block:nth-child(1) div.control-group.attribute-row:nth-child(5) div.controls > div.control-label")
    public WebElement alldayeventC;
    public String getAllday(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(alldayevent, 5);
        return alldayevent.getText()+alldayeventC.getText();
    }

    @FindBy(xpath = "//label[contains(text(),'Organizer')]")
    public WebElement organizer;
    @FindBy(xpath = "//div/a[contains(text(),'Stephan Haley')]")
    public WebElement organizerC;
    public String getOrganizer(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(organizer, 5);
        return organizer.getText()+organizerC.getText();
    }


    @FindBy(xpath = "//label[contains(text(),'Guests')]")
    public WebElement guest;
    @FindBy(xpath = "//a[contains(text(),'Tom Smith')]")
    public WebElement guestC;
    public String getGuest(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(guest, 5);
        return guest.getText()+guestC.getText();
    }

    @FindBy(xpath = "//label[contains(text(),'Recurrence')]")
    public WebElement recurrence;
    @FindBy(xpath = "//div[contains(text(),'Weekly every 1 week on Wednesday')]")
    public WebElement recurrenceC;
    public String getRecurrence(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(recurrence, 5);
        return recurrence.getText()+recurrenceC.getText();
    }


    @FindBy(xpath = "//label[contains(text(),'Call via Hangout')]")
    public WebElement call;
    @FindBy(css = "body.desktop-version.lang-en:nth-child(2) div.app-page:nth-child(2) div.app-page__content div.app-page__main div.app-page__central-panel div.scrollable-container:nth-child(3) div.layout-content:nth-child(2) div.layout-content.scrollable-container:nth-child(2) div.clearfix div.scrollspy.container-fluid.scrollable-container div.responsive-section.responsive-small:nth-child(1) div.section-content div.row-fluid div.form-horizontal div.responsive-cell div.row-fluid.form-horizontal div.responsive-block:nth-child(2) div.control-group.attribute-row div.controls > div.control-label")
    public WebElement callC;
    public String getCall(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(call, 5);
        return call.getText()+callC.getText();
    }





}
