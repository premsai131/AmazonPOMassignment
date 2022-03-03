package com.pages;

import com.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class HomePage extends Base {
    TodaysDeals todaysdeals;

    @FindBy(xpath="//a[contains(text(),\"Today's Deals\")]")
    WebElement todaysdealbtn;
    @FindBy(xpath="//div//h1[@class='a-size-extra-large a-spacing-micro']")
    WebElement todaysdealstext;

    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    WebElement searchField;

    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    WebElement searchBtn;





    public HomePage() throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String clickOnTodaysDealsbtn(){
       todaysdealbtn.click();
       return todaysdealstext.getText();

    }






}
