package com.pages;

import com.base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;

public class TodaysDeals extends Base {


    //NOW FIND THE 3RD ELEMENT IN THE TODAYS DEALS

    @FindBy(xpath = "(//div[@class='DealGridItem-module__dealItemContent_1vFddcq1F8pUxM8dd9FW32'])[3]")  //most generic xpath as it will click on 3rd element based on index
    WebElement thirdDeal; //for third element

    @FindBy(xpath = "(//a)[63]")
    WebElement firstproduct; //for clicking on the first product what ever the product it is

    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement firstProductTitle;


//    @FindBy(xpath=("(//div[@class='a-section octopus-dlp-image-shield'])[1]"))
//    WebElement boatAirpods; //1st element inside the 3rd element
//
//    @FindBy(xpath="//span[@id='productTitle']")
//    WebElement boatProductTitle; //element for getting the text of the boat air pod product single product

    @FindBy(xpath = "(//select)[3]")
    WebElement selectSize; //if the product is clothes

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartBtn; //element for add to cart button

    @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/span[2]/span[1]/input[1]")
    WebElement skipBtn; //skip buttin for autosuggested product after clicking on add to cart

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/form[1]/span[1]/span[1]/input[1]")
    WebElement cartBtn;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    WebElement actualQuantity; //main

    @FindBy(xpath="/html[1]/body[1]/div[1]/header[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[5]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[2]")
    WebElement actualQuantity1; //optional



    public TodaysDeals() throws FileNotFoundException {
        PageFactory.initElements(driver, this);
    }

    public String clickOnThirdDeal() {
        thirdDeal.click();
        firstproduct.click();
        return firstProductTitle.getText();
    }

    public String itemaddTOCartQty() throws InterruptedException {
        boolean flag = selectSize.isDisplayed();
        if (flag == true) {
            Select select = new Select(selectSize);
            select.selectByIndex(2);
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(("scroll(0,200)"));
        }

        addToCartBtn.click();
        Thread.sleep(1000); // i used to see the action in a static way
        //skipBtn.click();
        boolean flag2 = skipBtn.isDisplayed();
        System.out.println(flag2);
        if (flag2 == true) {
            skipBtn.click();
        }
//            cartBtn.click();
//        WebDriverWait mywait =new WebDriverWait(driver,5);
//        mywait.until(ExpectedConditions.elementToBeClickable(skipBtn));
        //Thread.sleep(5000);
//
//        addToCartBtn.click();
        String actualQty=null;
        boolean flag3 = actualQuantity.isDisplayed();
        boolean fla4 = actualQuantity1.isDisplayed();
        if (flag3 == true) {
             actualQty= actualQuantity.getText();
        } else if (fla4 == true) {
           actualQty= actualQuantity1.getText();
        }
        return actualQty;
    }


    }



