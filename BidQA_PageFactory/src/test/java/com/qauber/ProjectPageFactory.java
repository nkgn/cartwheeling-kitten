package com.qauber;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectPageFactory {

    WebDriver driver;

    @FindBy(name="project_title")
    WebElement projectTitle;

    @FindBy(name="project_description")
    WebElement projectDescription;

    @FindBy(xpath="//ul[@class='post-new']/li[6]/div[@class='multi_cat_placeholder_thing']")
    WebElement categoriesCheckBoxes ;

    @FindBy(xpath="//ul[@class='post-new']/li[9]/div[@class='multi_cat_placeholder_thing']")
    WebElement skillsCheckBoxes ;

    @FindBy(name="budgets")
    WebElement projectBudget;

    @FindBy(id="ending")
    WebElement projectEndingDate;


    @FindBy(name="project_location_cat")
    WebElement projectCountry ;

    @FindBy(id="subloc")
    WebElement projectState ;

    @FindBy(name="project_location_addr")
    WebElement projectLocationAddress ;

    @FindBy(name="project_submit1")
    WebElement projectSubmit1 ;

    @FindBy(name="project_submit2")
    WebElement projectSubmit2 ;

    @FindBy(xpath="//a[contains(text(),\"Next Step\")]")
    WebElement nextStep ;

    @FindBy(id="cb-payment")
    WebElement termsCheckBox ;

    @FindBy(xpath="//a[contains(text(),'Pay by Credits')]")
    WebElement payByCreditsButton ;

    @FindBy(id="pay_now")
    WebElement payNowButton ;

    @FindBy(xpath="//a[contains(text(),'your account')]")
    WebElement goToYourAccountLink ;

    /*@FindBy(xpath="//h2[contains(text(),'Category')]/following-sibling::div")
    WebElement skillsCheckBoxes;*/

    @FindBy(name="save-project")
    WebElement saveProjectButton;

    @FindBy(xpath = "//div[@id='content']/div/div/div/div/a/strong")
    WebElement clickHere;

    @FindBy(xpath="//input[@name='project_cat_cat_multi[]'][@value='65']")
    WebElement catAutomationMobile ;

    //project_skill_cat_multi[]
    @FindBy(xpath="//input[@name='project_skill_cat_multi[]'][@value='37']")
    WebElement skillsAutomationMobile ;


    public ProjectPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillProjectDescriptionTextArea(String newText) {
        projectDescription.sendKeys("\n"+ newText);
    }

    public void clickOnSaveProjectButton() {
        saveProjectButton.click();
    }

    public String getProjectdescription(){
        return projectDescription.getText();
    }

    public void clickOnClickHere() {
        Utilities.explicitWaitToClick(driver,4,projectDescription);
        clickHere.click();
    }

    public void fillProjectTitle(String projectname){
        projectTitle.sendKeys(projectname);
    }
    public void fillProjectDescription(String descrip){
        projectDescription.sendKeys(descrip);
    }

    public void selectSkillsAndCat(){
        catAutomationMobile.click();
        skillsAutomationMobile.click();
    }

    public void fillProjectBudget(int index){
        Select budget = new Select(projectBudget);
        budget.selectByIndex(index);
    }

    @FindBy(xpath="//div[@id='ui-datepicker-div']/div[1]/a[2]")
    WebElement nextMonth;

    @FindBy(xpath="//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[4]/a[contains(text(),'10')]")
    WebElement stDate;

    @FindBy(xpath="//div[@id='ui-datepicker-div']/div[3]/button[text()='Done']")
    WebElement doneButton;


    public void fillProjectEndingDate(String endDate){
        projectEndingDate.click();
        Utilities.explicitWaitToClick(driver,5,nextMonth);
        nextMonth.click();
        Utilities.explicitWaitToClick(driver,4,stDate);
        stDate.click();
        doneButton.click();
    }

    public void fillProjectCountry(int index){
        Select country = new Select(projectCountry);
        country.selectByIndex(index);
    }
    public void fillProjectState(int index){
        Select state = new Select(projectState);
        state.selectByIndex(index);
    }

    public void fillProjectLocationAddress(String addr){
        projectLocationAddress.sendKeys(addr);
    }

    public void clickOnProjectSubmit1(){
        Utilities.explicitWaitToClick(driver,3,projectSubmit1);
        projectSubmit1.click();
    }
    public void clickOnProjectSubmit2(){
        Utilities.explicitWaitToClick(driver,7,projectSubmit2);
        projectSubmit2.click();
    }

    public void clickOnNextStep(){
        Utilities.explicitWaitToClick(driver,4,nextStep);
        nextStep.click();
    }
    public void selectTermsCheckBox(){
        Utilities.explicitWaitToClick(driver,4,termsCheckBox);
        termsCheckBox.click();
    }
    public void clickOnPayByCreditsButton(){
        Utilities.explicitWaitToClick(driver,3,payByCreditsButton);
        payByCreditsButton.click();
    }
    public void clickOnPayNowButton(){
        Utilities.explicitWaitToClick(driver,7,payNowButton);
        payNowButton.click();
    }

    public void clickOnGoToYourAccountLink(){
        Utilities.explicitWaitToClick(driver,5,goToYourAccountLink);
        goToYourAccountLink.click();
    }

}
