package com.uberAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.uberAutomation.Test.Utilities;

/**
 * Created by nitu on 5/3/2017.
 */
public class HomePageFactory {

    private WebDriver driver;

    @FindBy(xpath="//li[starts-with(@id,'menu-item')]/a[@data-hover='Login/Sign Up']")
    WebElement loginTab ;

    @FindBy(xpath="//li[starts-with(@id,'menu-item')]/a[@data-hover='Login/Sign Up']")
    WebElement AccountType ;


    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickOnLoginTab() {
        Utilities.explicitWaitToClick(driver,10,loginTab);
        loginTab.click();
    }

}
