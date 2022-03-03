package com.pages;

import com.base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class YourOrdersPage extends Base {

    //This page is only for showing past oneYear orders

    @FindBy(xpath="//h2[contains(text(),'Your Orders')]")
    WebElement yourOrders;

    @FindBy(xpath="//span[@class='a-dropdown-prompt']")
    WebElement ordersDate;

    @FindBy(xpath="//div//ul//li//a[contains(text(),'2021')]")
    WebElement ordersFromLastOneYear;

    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement accountsAndLists; //for going to sign in mouse over action

    public YourOrdersPage() throws FileNotFoundException {
        super();
        PageFactory.initElements(driver,this);
    }

    public void goToPastOrders() throws InterruptedException {
        Actions action=new Actions(driver);
        //action.moveToElement(accountsAndLists).build().perform();
        accountsAndLists.click();
        yourOrders.click();
        ordersDate.click();
        ordersFromLastOneYear.click();
        Thread.sleep(2500);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(("scroll(0,200)"));
    }

}
