package com.pages;

import com.base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.Properties;

public class PaymentOptionsPage extends Base {
    WebDriverWait myWait;



    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement accountsAndLists; //accounts and list locator

    @FindBy(xpath="//h2[contains(text(),'Payment options')]")
    WebElement paymentOptionsBtn;

    @FindBy(xpath="//span[contains(text(),'Your Payment Options')]")
    WebElement paymentOptionsPageText;

    @FindBy(xpath="//span[@id='pp-4LfCV4-40-announce']")
    WebElement addCardBtn;

    @FindBy(xpath="//a[contains(text(),'Manage Bank Accounts')]")
    WebElement manageBankAccounts;


    @FindBy(xpath="//input[@id='IFSC_yes']/following-sibling::i")  //input[@id='IFSC_yes'] from this to sibling
    WebElement IFSCOption; //radio button for clicking on yes/No

    @FindBy(xpath="//span[contains(text(),'Add a New Bank Account')]")
    WebElement addNewBankAccount;

    @FindBy(xpath="//input[@id='enterIFSCInput']")
    WebElement IFSCInputField; // ifsc code entering input feild

    @FindBy(xpath="//button[@id='confirmIFSCButton']")
    WebElement confirmIFSCCODE;

    @FindBy(xpath="//input[@id='addBankAccountHolderName']")
    WebElement accountHolderNameInputField; //account holder name field

    @FindBy(xpath="//input[@id='addBankAccountNumber']")
    WebElement bankAccountNumberInputField; //bank account number input field

    @FindBy(xpath="//input[@id='confirmAddBankAccountNumber']")
    WebElement confirmBankAccountNumberField;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/form[1]/div[7]/div[5]/div[2]/span[1]/span[1]/span[1]/span[1]/span[1]")
    WebElement accountTypeBtn;

    @FindBy(xpath="//a[contains(text(),'Savings')]")
    WebElement savingsBtn;

    @FindBy(xpath="//button[@id='saveWithoutValidationButton']")
    WebElement saveAndAddButton;

    @FindBy(xpath="//span[contains(text(),'Account Added')]")
    WebElement accountAddedText;  //text message of account added or not

    @FindBy(xpath="//input[@id='modal_trigger']")
    WebElement deleteBankAccount;
    //input[@id='yesButton_1']

    @FindBy(css="#yesButton_1")  //xpath="//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]"
    WebElement yesBtn;

    @FindBy(xpath="//span[contains(text(),'Account Deleted')]")
    WebElement accountDeletedDisplayText;



    public PaymentOptionsPage() throws FileNotFoundException {

        PageFactory.initElements(driver,this);
    }

    public String  paymentOptionBtn(){
        accountsAndLists.click();
        paymentOptionsBtn.click();
        return paymentOptionsPageText.getText();
    }

    public String visibilityOfAddPaymentOption() throws InterruptedException  {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(("scroll(0,500)"));
        Thread.sleep(5000);

        boolean visibilityOFElement=addCardBtn.isDisplayed();
        System.out.println(visibilityOFElement);
        return addCardBtn.getText();

    }

    public String addNewBankAccount() throws InterruptedException {
        manageBankAccounts.click();
        addNewBankAccount.click();

//        WebDriverWait myWait=new WebDriverWait(driver,5);
//        myWait.until(ExpectedConditions.elementToBeClickable(IFSCOption));
        IFSCOption.click();
        String ifscCode=prop.getProperty("IFSCCODE");
        String holderName=prop.getProperty("accountHolderName");
        String bankAccountNumber=prop.getProperty("bankAccountNumber");
        String confirmBankAccountNUmber=prop.getProperty("confirmBankAccountNumber");
        IFSCInputField.sendKeys(ifscCode);
        confirmIFSCCODE.click();

        accountHolderNameInputField.sendKeys(holderName);
        bankAccountNumberInputField.sendKeys(bankAccountNumber);
        confirmBankAccountNumberField.sendKeys(confirmBankAccountNUmber);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(("scroll(0,200)"));
        Thread.sleep(2000);
        accountTypeBtn.click();  ///some times this is showing as failing or unable to locate buyt still it is clicking on it
        savingsBtn.click();
        saveAndAddButton.click();
       return  accountAddedText.getText();
    }

    public String deleteBankAccount(){  //becuase to add the same account multiple time i have to delete it first then can add
        deleteBankAccount.click();
//        myWait=new WebDriverWait(driver,5);
//        myWait.until(ExpectedConditions.elementToBeClickable(yesBtn));
//        Alert alert=driver.switchTo().alert();
//        alert.accept();
        yesBtn.click();
        return accountDeletedDisplayText.getText();
    }
}


