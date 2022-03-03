package com.test;

import com.base.Base;
import com.pages.DeliveryAddressPage;
import com.pages.YourAccountsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class DeliveryAddressPageTest extends Base {

    //evevry this is fine both the text cases are getting passed
    //1.adding the delivery addresss and validating added or not
    //2.deleting delivery address and validating deleted or im deleting the address  beacause each time in run the test case address will be added
    //sometimes it shows address already exists so to avoid that i allways delete address after adding it.

    DeliveryAddressPage deliveryaddress;
    YourAccountsPage yourAccountsPage;





    public DeliveryAddressPageTest() throws FileNotFoundException {
        super();
    }


    @BeforeClass
    public void setup() throws FileNotFoundException {
        Base.initialization();
         yourAccountsPage=new YourAccountsPage();
         deliveryaddress=new DeliveryAddressPage();
        yourAccountsPage.SignIn();

    }

    @AfterClass
    public void quit() {
        //driver.quit();
    }


  @Test(priority =0)
    public void validateAddNewDeliveryAddress() throws InterruptedException {
        String actualPersonName=deliveryaddress.addNewDeliveryAddress();
        String expectedPersonName="premsai";
      Assert.assertEquals(actualPersonName,expectedPersonName,"person name not matching");
    }

    @Test(priority=1)
    public void validatedeleteAddress(){

        String actual=deliveryaddress.deleteAddress();
        String expected="Address deleted";

        Assert.assertEquals(actual,expected,"address not deleted");
    }
}
