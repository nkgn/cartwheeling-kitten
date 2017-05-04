
package com.uberAutomation.Pages;

        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import com.uberAutomation.Test.Utilities;
        import org.openqa.selenium.support.ui.Select;


public class LoginPageFactory {

    private WebDriver driver;

    @FindBy(id="i-e-type")
    WebElement accountType ;

    @FindBy(id="reg_email")
    WebElement emailTextBox ;

    @FindBy(id="reg_password")
    WebElement pwdTextBox ;

    @FindBy(id="creg_password")
    WebElement confirmPwdTextBox ;

    @FindBy(id="i-e-name")
    WebElement accountName ;

    @FindBy(id="i-e-address")
    WebElement address ;

    @FindBy(id="i-e-first")
    WebElement firstName ;

    @FindBy(id="i-e-last")
    WebElement lastName ;

    @FindBy(id="i-e-phone")
    WebElement phone ;

    @FindBy(id="i-e-zip")
    WebElement zip ;

    @FindBy(id="countryId")
    WebElement country ;

    @FindBy(id="stateId")
    WebElement state ;

    @FindBy(id="cityId")
    WebElement city ;


    @FindBy(id="i-e-paypal")
    WebElement paypalAcc ;

    @FindBy(name="register")
    WebElement registerButton ;

    @FindBy(id="acceptterms")
    WebElement acceptTerms ;

    @FindBy(xpath=".//*[@id='terms-modal']/div/p[2]/span")
    WebElement acceptTermsNext ;

    @FindBy(xpath=".//*[@id='terms-modal']/div")
    WebElement acceptTermsDialog ;



    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void selectAccountType(int index) {
        Utilities.explicitWaitToClick(driver,10,accountType);

        Select aType = new Select(accountType);
        aType.selectByIndex(index);
    }

    public void fillEmailTextBox(String emailid){
        emailTextBox.sendKeys(emailid);
    }

    public void fillPwdTextBox(String pwd){
        pwdTextBox.sendKeys(pwd);
    }

    public void fillConfirmPwdTextBox(String pwd){
        confirmPwdTextBox.sendKeys(pwd);
    }
    public void fillAccountName(String name){
        accountName.sendKeys(name);
    }

    public void fillFirstName(String first) {
       // Utilities.explicitWaitToClick(driver,10,firstName);
        firstName.sendKeys(first);
    }

    public void fillLastName(String last) {
        // Utilities.explicitWaitToClick(driver,10,lastName);
        lastName.sendKeys(last);
    }

    public void fillAddress(String addre) {
        // Utilities.explicitWaitToClick(driver,10,address);
        address.sendKeys(addre);
    }


    public void fillPhone(String ph) {
        // Utilities.explicitWaitToClick(driver,10,phone);
        phone.sendKeys(ph);
    }

    public void fillZipCode(String z) {
        // Utilities.explicitWaitToClick(driver,10,zip);
        zip.sendKeys(z);
    }
    public  void selectCountry(int index) {
        Utilities.explicitWaitToClick(driver,10,country);

        Select countryName = new Select(country);
        countryName.selectByIndex(index);
    }
    public  void selectState(int index) {
        Utilities.explicitWaitToClick(driver,10,state);

        Select stateName = new Select(state);
        stateName.selectByIndex(index);
    }

    public  void selectCity(int index) {
        Utilities.explicitWaitToClick(driver,10,city);

        Select cityName = new Select(city);
        cityName.selectByIndex(index);
    }



    public void fillPaypal(String paypalID) {
        // Utilities.explicitWaitToClick(driver,10,paypalAcc);
        paypalAcc.sendKeys(paypalID);
    }




    public void clickNext(){
        registerButton.click();
    }

    public void clickOnAcceptTerms(){
        //driver.switchTo().;

        /*Set<String> handles = driver.getWindowHandles();
        String child = driver.getWindowHandle();
        for(String a : handles){

            if (!child.equals(a))
                driver.switchTo().window(a).close();
        }
        driver.switchTo().window(child);
 		  */
        System.out.println(driver.getWindowHandle());
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(700,900);");
        Utilities.explicitWaitToClick(driver,30,acceptTerms);
        acceptTerms.click();
    }
    public void clickOnNext(){
        Utilities.explicitWaitToClick(driver,30,acceptTermsNext);
        acceptTermsNext.click();
    }


    public void scrollAcceptTermsDialog(){
        String keysPressed =  Keys.chord(Keys.CONTROL, Keys.END);
        acceptTermsDialog.sendKeys(keysPressed) ;
        //acceptTermsDialog.sendKeys(Keys.CONTROL+END;
    }
}
