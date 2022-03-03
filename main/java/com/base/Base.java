package com.base;

import com.utilities.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties prop;


    public Base() throws FileNotFoundException {

        prop =new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\PREMSAI\\IdeaProjects\\Amazon\\src\\main\\java\\com\\resourses\\config.properties");
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        String browserUrl=prop.getProperty("url");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\firefoxdriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(CommonUtils.implicitWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(CommonUtils.pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(browserUrl);


    }

}


