package com.uberAutomation.Test;

import com.uberAutomation.Pages.LoginPageFactory;
import com.uberAutomation.TestData.GenerateLoginTestData;
import org.openqa.selenium.WebDriver;

/**
 * Created by nitu on 5/3/2017.
 */
public class LoginTest {
    private LoginPageFactory loginPage ;
    GenerateLoginTestData loginData;
    private WebDriver driver;
    public LoginTest(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPageFactory(driver);
        loginData = new GenerateLoginTestData();
    }
    public void LoginAsCityJournalist() throws InterruptedException {
        loginPage.selectAccountType(3);
        loginPage.fillEmailTextBox(loginData.email);
        loginPage.fillPwdTextBox(loginData.password);
        loginPage.fillConfirmPwdTextBox(loginData.password);
        loginPage.fillAccountName(loginData.accountName);
        loginPage.fillFirstName(loginData.firstName);
        loginPage.fillLastName(loginData.lastName);
        loginPage.fillAddress(loginData.address);
        loginPage.fillPhone("111-111-1111");
        loginPage.selectCountry(5);
        Thread.sleep(5000);
        loginPage.selectState(2);
        Thread.sleep(5000);
        loginPage.selectCity(1);
        loginPage.fillZipCode("94539");
        loginPage.fillPaypal(loginData.paypal);
        System.out.println(driver.getWindowHandle());
        loginPage.clickNext();
        Thread.sleep(9000);
        loginPage.scrollAcceptTermsDialog();
        System.out.println(driver.getWindowHandle());
        loginPage.clickOnAcceptTerms();
        loginPage.clickOnNext();
    }
}
