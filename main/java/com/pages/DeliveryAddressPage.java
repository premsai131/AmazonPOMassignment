package com.pages;

import com.base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.WeakHashMap;

public class DeliveryAddressPage extends Base {

    @FindBy(xpath="//span[@id='glow-ingress-line1']")
    WebElement rootDeliveryBtn;

    @FindBy(partialLinkText="Add an address or pi")
    WebElement addNewDeliveryAddressBtn;

    @FindBy(xpath="//div[@class='a-section a-spacing-none address-plus-icon aok-inline-block']")
    WebElement addAddressBtn;

    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement fullName;

    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement mobileNumber;

    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
    WebElement pincode;

    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
    WebElement flatAddress;

    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
    WebElement areaAndLocality;

    @FindBy(xpath="//input[@id='address-ui-widgets-landmark']")
    WebElement landMark;
    
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")
    WebElement townOrCity;

    @FindBy(xpath="(//span//i)[8]")
    WebElement state;

    @FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/div[2]/div[4]/span[1]/span[1]/span[1]/span[1]")
    WebElement addressType;

    @FindBy(xpath="//a[@id='dropdown1_1']")
    WebElement deliveryTime;

    @FindBy(xpath="//body/div[@id='a-page']/div[2]/div[1]/div[2]/form[1]/span[1]/div[1]/span[1]/span[1]/span[1]/input[1]")
    WebElement addAddress;

    @FindBy(xpath="//span[contains(text(),'premsai')]")
    WebElement personAddressName;

    @FindBy(xpath="(//span/a[contains(text(),'Remove')])[2]")
    WebElement removeAddress;

    //span//input/following-sibling::span)[14] // getting element not interactable exception with this locator
    @FindBy(css="body.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_launch_2021_ally_fixes_392482-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-modal-scroller.a-declarative:nth-child(9) div.a-popover.a-popover-modal.a-declarative div.a-popover-wrapper div.a-popover-inner div.a-section div.a-row:nth-child(4) div.a-column.a-span6.a-span-last:nth-child(2) div.a-row div.a-column.a-span8:nth-child(2) form.a-spacing-none span.a-button.a-button-span12.a-button-primary:nth-child(4) span.a-button-inner > input.a-button-input")
    WebElement confirm;

    @FindBy(xpath="//h4[contains(text(),'Address deleted')]")
    WebElement addressDeleteCheck;




    public DeliveryAddressPage() throws FileNotFoundException {
        PageFactory.initElements(driver,this);

    }

    public String addNewDeliveryAddress() throws InterruptedException{
        rootDeliveryBtn.click();
//        WebDriverWait myWait=new WebDriverWait(driver,5);
//        myWait.until(ExpectedConditions.visibilityOf(addNewDeliveryAddressBtn));
        addNewDeliveryAddressBtn.click();
        addAddressBtn.click();
        fullName.sendKeys("premsai");
        mobileNumber.sendKeys("9100249549");
        pincode.sendKeys("516360");
        flatAddress.sendKeys("4/144");
        areaAndLocality.sendKeys("proddatur");
        landMark.sendKeys("proddatur");
        townOrCity.sendKeys("proddatur");
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(("scroll(0,350)"));
        Thread.sleep(4000);

//        Select selectState=new Select(state);
//        selectState.selectByVisibleText("ANDHRA PRADHESH");

//        Select selectAddress=new Select(addressType);
//        selectAddress.selectByIndex(0);
        addressType.click();
        deliveryTime.click();
        addAddress.click();
        return personAddressName.getText();

    }

    public String deleteAddress(){
        removeAddress.click();
        confirm.click();
        System.out.println(addressDeleteCheck.getText());
        return(addressDeleteCheck.getText());
    }
}
