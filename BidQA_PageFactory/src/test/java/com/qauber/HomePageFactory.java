package com.qauber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nitu on 4/23/2017.
 */
public class HomePageFactory {

    private WebDriver driver ;

    @FindBy(xpath="//i[@class='login-awsome']")
    WebElement loginTab;

    @FindBy(xpath="//img[@id='logo']")
    WebElement bidQaLogo;

    @FindBy(xpath="//i[@class='post-new-awsome']")
    WebElement postNewProjectTab;


    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickOnLoginTab() {
        Utilities.explicitWaitToClick(driver,5,loginTab);
        loginTab.click();
    }

    public  void clickOnBidQalogo() {
        bidQaLogo.click();
    }

    public  void clickOnPostNewProjectTab() {
        Utilities.explicitWaitToClick(driver,5,postNewProjectTab);
        postNewProjectTab.click();
    }



}
