package com.qauber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by nitu on 4/23/2017.
 */
public class LoginPageFactory {

    private WebDriver driver ;

    @FindBy(id="log")
    WebElement loginTextBox;

    @FindBy(id="login_password")
    WebElement passwordTextBox;

    @FindBy(id="submits")
    WebElement signInButton;



    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public  void fillLoginTextBox(String username) {

        loginTextBox.sendKeys(username);
    }


    public  void fillPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
    }


    public void clickOnSignInButton() {
        signInButton.click();
    }


}
