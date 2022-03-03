package com.test;

import com.base.Base;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class HomePageTest extends Base {
    HomePage homepage;
    public HomePageTest() throws FileNotFoundException {
        super();
    }

    @BeforeClass
    public void setup() throws FileNotFoundException {
        homepage =new HomePage();
        Base.initialization();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }


    @Test
    public void homePageTitleTest(){
        String actual = homepage.getTitle();
        String expected ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        System.out.println(actual);

        Assert.assertEquals(expected,actual,"page title not matched ");
    }

}
