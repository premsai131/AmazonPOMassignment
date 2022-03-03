package com.pages;

import com.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

public class SearchPage extends Base {

    //this page is only for searching the mobile and getting the details of it
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    WebElement searchField; //locator for search text field

    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    WebElement searchBtn; //locator for search button

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[24]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]")
    WebElement lastMobile; //for getting the last item in the page it is so dynamic

    @FindBy(xpath="//span[@id='productTitle']")
    WebElement mobileDetails;





    public SearchPage() throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }

    public void searchForMobiles(){
        searchField.sendKeys("Mobiles");
        searchBtn.click();
    }

    public String  mobileDetails() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,5500)");
        //js.executeScript("arguments[0].scrollIntoView(true);", lastMobile);
//

       Thread.sleep(5000);
        lastMobile.click();
        Set<String> windowIds=driver.getWindowHandles();
        Iterator<String> it=windowIds.iterator();
         String parentWindow=it.next();
         String childWindow=it.next();
         driver.switchTo().window(childWindow);
        return mobileDetails.getText();
        }

    }

