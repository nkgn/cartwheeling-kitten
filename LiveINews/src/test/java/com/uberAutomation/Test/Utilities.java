package com.uberAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utilities {

    public static void explicitWaitToClick(WebDriver driver, int time, WebElement element){
        new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
    }


    /*public static void loginAsProjectOwner(String username, String password,
                                           WebDriver driver, LoginPageFactory lp,
                                           HomePageFactory hp){

        hp.clickOnLoginTab();
        lp.fillLoginTextBox(username);
        lp.fillPasswordTextBox(password);
        lp.clickOnSignInButton();
    }*/

}
