package com.pages;

import com.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class SignOut extends Base {
    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement accountsAndLists; //for going to sign in

    @FindBy(xpath="//span[text()='Sign Out']")
    WebElement signOutbtn;

    @FindBy(xpath="//label[contains(text(),'Email or mobile phone number')]")
    WebElement siginingInText;



    public SignOut() throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }

    public void clickOnSignoutBtn(){
        Actions action=new Actions(driver);
        action.moveToElement(accountsAndLists).build().perform();
        signOutbtn.click();
       // return siginingInText.getText();


    }

}
