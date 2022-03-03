package com.test;

import com.base.Base;
import com.pages.HomePage;
import com.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SearchPageTest extends Base {


    HomePage homePage;
    SearchPage searchPage;
    public SearchPageTest() throws FileNotFoundException {
        super();
    }


    @BeforeClass
    public void setup() throws FileNotFoundException {
        Base.initialization();
        searchPage=new SearchPage();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Test(priority = 1)
    public void validateSearchForMobiles(){
        searchPage.searchForMobiles();
    }

    @Test(priority = 2)
    public void validateMobileDetails() throws InterruptedException {
        String actual=searchPage.mobileDetails();
        //String expected="I KALL Z4 4G Smartphone (5.5 Inch, 4GB, 32GB) (Blue)";
        System.out.println(actual);

       // Assert.assertEquals(expected,actual,"product details not matched");
    }


}
