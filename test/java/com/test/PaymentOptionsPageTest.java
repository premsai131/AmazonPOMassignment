package com.test;

import com.base.Base;
import com.pages.PaymentOptionsPage;
import com.pages.SignOut;
import com.pages.YourAccountsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Properties;

public class PaymentOptionsPageTest extends Base {
    YourAccountsPage yourAccountsPage;
    PaymentOptionsPage paymentOptionsPage;
    SignOut signOut;
    Properties prop;

    public PaymentOptionsPageTest() throws FileNotFoundException {
        super();

    }

    @BeforeClass
    public void setup() throws FileNotFoundException {
        Base.initialization();
        paymentOptionsPage=new PaymentOptionsPage();
        yourAccountsPage=new YourAccountsPage();
        prop =new Properties();
        yourAccountsPage.SignIn();

    }
    @AfterClass
    public void quit() throws FileNotFoundException {
        signOut=new SignOut();
        signOut.clickOnSignoutBtn();
        driver.quit();
    }

    @Test (priority =0)
    public void validatePaymentOptionBtn() {
       String actual= paymentOptionsPage.paymentOptionBtn();
       String expected="Your Payment Options";

        Assert.assertEquals(actual,expected,"both are not matching");

    }
//    @Test(priority =1)
//    public void validateAddCardBtn() throws InterruptedException {
//       String actual= paymentOptionsPage.visibilityOfAddPaymentOption();
//       String expected="Add a credit or debit card";
//       Assert.assertEquals(actual,expected,"Add button is not visible");
//    }
//
//    @Test (priority =2)
//    public void validateAddNewBankAccount() throws InterruptedException {
//        String actual=paymentOptionsPage.addNewBankAccount();
//        String expected="Account Added";
//
//        Assert.assertEquals(actual,expected,"account not added there is some issue");
//    }

//    @Test(priority =2)
//        public void validateDeleteBankAccount(){
//       String actual= paymentOptionsPage.deleteBankAccount();
//       String expected="Account Deleted";
//
//       Assert.assertEquals(actual,expected,"account still not deleted");
//
//        }
    }





