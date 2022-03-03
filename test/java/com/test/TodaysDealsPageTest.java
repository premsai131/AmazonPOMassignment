package com.test;

import com.base.Base;
import com.pages.HomePage;
import com.pages.TodaysDeals;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class TodaysDealsPageTest extends Base {
    HomePage homePage;
    TodaysDeals todaysDeals;

    public TodaysDealsPageTest() throws FileNotFoundException {
        super();
    }


    @BeforeClass
    public void setup() throws FileNotFoundException {
        Base.initialization();
        homePage =new HomePage();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test (priority =0)
    public void validateTodaysDeal() {
        String actual=homePage.clickOnTodaysDealsbtn(); //iam calling home page object here because todays deals is belongingt to home page
        String expected="Today's Deals"; ///for validating "todays deal page"
        Assert.assertEquals(expected,actual,"Title not matching");


    }
//    @Test(priority = 1)
//    public void validateClickOnThirdDeal() throws FileNotFoundException {  //clicking on third deal and validating with the actual
//        todaysDeals=new TodaysDeals();
//       String actaul= todaysDeals.clickOnThirdDeal();
//       String expected="Best Prices on boAt";
//       Assert.assertEquals(expected,actaul,"title not matching");
//    }

//    @Test (priority = 2)
//    public void validateclickOnBoatAirPods(){ //clicking on boat earpods and validating with the actual
////        String actual=todaysDeals.clickOnThirdDeal();
////        String expected="boAt Airdopes 141 True Wireless Earbuds with 42H Playtime, Beast Mode(Low Latency Upto 80ms) for Gaming, ENx Tech, ASAP Charge, IWP, IPX4 Water Resistance, Smooth Touch Controls(Bold Black)";
////        Assert.assertEquals(actual,expected,"both are not matching");
//
//    }

    @Test (priority = 1)
        public void validateItemAddTOCartQty() throws InterruptedException, FileNotFoundException {
        todaysDeals=new TodaysDeals();
       String productTitle= todaysDeals.clickOnThirdDeal();
        System.out.println(productTitle);
        String actualQty= (todaysDeals.itemaddTOCartQty());
        System.out.println(actualQty +1);
        String expectedQty="1";
        Assert.assertEquals(expectedQty,actualQty,"both the quantities are not matching");

        }


    }





