package com.uberAutomation.Test;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import com.uberAutomation.Pages.HomePageFactory;
import com.uberAutomation.Pages.LoginPageFactory;

public class AppTest
{
    private WebDriver driver ;
    private String baseURL = "";
    private String expectedTitle = "";
    private HomePageFactory homePage ;
    private LoginTest login;

    @BeforeClass
    public void setUp()  {
        System.setProperty("webdriver.gecko.driver", "C:/Users/nitu/Desktop/SeleniumWebDriver/geckodriver.exe");
        driver = new FirefoxDriver();
        baseURL="http://www.liveinews.com";

        driver.get(baseURL);
        expectedTitle="LiveiNews";
        try {
            assertEquals(driver.getTitle(), expectedTitle);
            driver.manage().window().maximize();// .manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }catch(Exception e){
            System.out.println("Exception generated in setUp ");
            e.printStackTrace();
        }
        homePage = new HomePageFactory(driver);
        login = new LoginTest(driver);
    }
    @Test
    public void test0() throws InterruptedException {
        System.out.println("Inside test");
        homePage.clickOnLoginTab();
        login.LoginAsCityJournalist();
    }


    @AfterClass
    public void tearDown(){
        driver.close();
        //driver.quit();
    }
}
