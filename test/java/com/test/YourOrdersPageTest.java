package com.test;

import com.base.Base;
import com.pages.SignOut;
import com.pages.YourAccountsPage;
import com.pages.YourOrdersPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class YourOrdersPageTest extends Base {

    YourAccountsPage yourAccountsPage;
    SignOut signOut;
    YourOrdersPage yourOrdersPage;
    public YourOrdersPageTest() throws FileNotFoundException {
        super();
    }


    @BeforeClass
    public void setup() throws FileNotFoundException {
        Base.initialization();
        yourAccountsPage=new YourAccountsPage();
        yourOrdersPage=new YourOrdersPage();
        signOut=new SignOut();
        yourAccountsPage.SignIn();
    }

    @AfterClass
    public void quit(){
        signOut.clickOnSignoutBtn();
        driver.quit();
    }

    @Test
    public void validategoToPastOrders() throws InterruptedException {
        yourOrdersPage.goToPastOrders();
    }
}
