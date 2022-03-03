package com.pages;

import com.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class YourAccountsPage extends Base {

    //this page is only for elements up to checking the the delivery status thats it


    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement accountsAndLists; //for going to sign in

    @FindBy(xpath="//input[@name='email']")
    WebElement signInField;  //username input feild

    @FindBy(xpath="//input[@id='continue']")
    WebElement continueBtn; //continue btn after entering username
    @FindBy(xpath="//input[@id='ap_password']")
    WebElement passwordField; //password input field

    @FindBy(xpath="//input[@id='signInSubmit']")
    WebElement SignInbtn; //for  sign in button

    @FindBy(xpath="//a[@id='nav-logo-sprites']")
    WebElement amazonLogo; //for locating the logo after signing in

    @FindBy(xpath="//span[text()='View benefits and payment settings']")
    WebElement primeBtn; //locator for clicking on prime button

    @FindBy(xpath="(//a//img)[1]")
    WebElement firstDisplayedItem; //for locating the first displayed item(airpods)

    @FindBy(xpath="//b[contains(text(),'Tomorrow')]")
    WebElement deliveryStatus; //for locating the delivery status button





    public YourAccountsPage() throws FileNotFoundException  {
        PageFactory.initElements(driver,this);
    }


    public boolean SignIn(){
        accountsAndLists.click();
        //accountsAndLists.click();
        String uname= prop.getProperty("username");
        String pword=prop.getProperty("password");
        signInField.sendKeys(uname);
        continueBtn.click();
        passwordField.sendKeys(pword);
        SignInbtn.click();
        return amazonLogo.isDisplayed();
    }

    public void clickOnaccountsPage(){ //this is like a dummy method which will be called inside the another method
        accountsAndLists.click();
    }

    public String CheckdeliveryStatus(){
        accountsAndLists.click(); //for clicking on accounts list btn;
        primeBtn.click(); //for clicking on prime button
        firstDisplayedItem.click();
        return deliveryStatus.getText();

    }
}
