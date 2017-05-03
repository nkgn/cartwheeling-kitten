package com.qauber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nitu on 4/23/2017.
 */
public class MyAccountPageFactory {

    private WebDriver driver;

    @FindBy(id="my-top-search-input")
    WebElement searchTextBox;

    @FindBy(id="my-top-submit-input")
    WebElement searchButton;

    @FindBy(xpath="//div[@id='post-4515']//a[contains(text(),'Edit Project')]")
    WebElement editButton;

    public MyAccountPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void fillSearchTextBox(String searchText) {

        searchTextBox.sendKeys(searchText);
    }

    public  void clickSearchButton() {
        Utilities.explicitWaitToClick(driver,5,searchButton);
        searchButton.click();
    }

    public  void clickEditButton() {
        Utilities.explicitWaitToClick(driver,5,editButton);
        editButton.click();
    }

}
