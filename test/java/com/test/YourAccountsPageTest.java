package com.test;

import com.base.Base;
import com.pages.SignOut;
import com.pages.YourAccountsPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.Properties;

public class YourAccountsPageTest extends Base {
    YourAccountsPage yourAccountsPage;
    SignOut signOut;
    Properties prop;


    public YourAccountsPageTest() throws FileNotFoundException {
        super();

    }

    @BeforeClass
    public void setup() throws FileNotFoundException {

        Base.initialization();
        prop=new Properties();
        yourAccountsPage=new YourAccountsPage();
    }

    @AfterClass
    public void quit() throws FileNotFoundException {
        signOut =new SignOut();
        signOut.clickOnSignoutBtn();
        driver.quit();
    }

    @Test (priority =0)
    public void validateSignIn(){
        boolean flag=yourAccountsPage.SignIn();
        Assert.assertTrue(flag);
    }

    @Test(priority=1)
    public void validateCheckDeliveryStatus(){
        String actual=yourAccountsPage.CheckdeliveryStatus();
        String expected="Tomorrow";
        //Assert.assertEquals(actual,expected,"delivery status not matched");
        System.out.println(actual);

    }


}
