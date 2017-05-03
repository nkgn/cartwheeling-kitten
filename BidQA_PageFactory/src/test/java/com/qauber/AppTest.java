package com.qauber;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class AppTest
{
    private WebDriver driver ;
    private String baseURL = "";
    private HomePageFactory homepage ;
    private LoginPageFactory loginpage;
    private MyAccountPageFactory myaccount ;
    private ProjectPageFactory projectFactory;
    private String expectedTitle = "";

    @BeforeClass
    @Parameters({"username","password"}) //paramterized test need to run from testng.xml
    public void setUp(String username,String password)  {
        System.setProperty("webdriver.gecko.driver", "C:/Users/nitu/Desktop/SeleniumWebDriver/geckodriver.exe");
        driver = new FirefoxDriver();
        baseURL="http://test.bidqa.com";

        driver.get(baseURL);
        expectedTitle="BidQA | Marketplace for available QA Professionals around a globe";
        try {
            assertEquals(driver.getTitle(), expectedTitle);
            driver.manage().window().maximize();// .manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }catch(Exception e){
            System.out.println("Exception generated in setUp ");
            e.printStackTrace();
        }
        homepage = new HomePageFactory(driver);
        loginpage = new LoginPageFactory(driver);
        myaccount= new MyAccountPageFactory(driver);
        projectFactory = new ProjectPageFactory(driver);
        try{
            Utilities.loginAsProjectOwner(username, password, driver, loginpage, homepage);
            Thread.sleep(5000);
            assertEquals(driver.getTitle(), "BidQA | My Account");
        }catch(Exception e){
            System.out.println("Exception generated while logging in  with valid credentials ");
            e.printStackTrace();
        }
    }

    /***Verify that project owner can edit thr project description***/
    @Test(enabled = true) //(priority = 0)
    public void test0()  {
        try {
            //Step 1 : Enter project name to search
            myaccount.fillSearchTextBox("Travel site");
            myaccount.clickSearchButton();
            Thread.sleep(5000);
            expectedTitle="BidQA | Project Search";
            assertEquals(driver.getTitle(),expectedTitle );
        }catch(Exception e){
            System.out.println("Exception generated while searching project in test0 ");
            System.out.println("Expected title : " + expectedTitle);
            System.out.println("Actual title : " + driver.getTitle());
            e.printStackTrace();
        }
    }
    @Test(enabled = true)//(priority = 1)
    public void test1() {
        try {
            //Step 2 : Click edit project button under the selected project
            Thread.sleep(4000);
            myaccount.clickEditButton();
            Thread.sleep(4000);
            expectedTitle = "BidQAEdit Project - | Marketplace for available QA Professionals around a globe";
            assertEquals(driver.getTitle(), expectedTitle);
        }catch(Exception e){
            System.out.println("Exception generated in test1 ");
            System.out.println("Expected title : " + expectedTitle);
            System.out.println("Actual title : " + driver.getTitle());
            e.printStackTrace();
        }
    }
    @Test(enabled = true)//(priority = 2)
    public void test2()  {
        try {
            //step 3: edit the project details
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            projectFactory.fillProjectDescriptionTextArea(timeStamp);

            //step 4: save the changes by clicking save project button
            projectFactory.clickOnSaveProjectButton();
            Thread.sleep(2000);

            //step 5 : confirm the changes and press "click here"
            projectFactory.clickOnClickHere();
            Thread.sleep(5000);
            expectedTitle = "BidQA | Travel site";
            assertEquals(driver.getTitle(), expectedTitle);
            //Expected results : Project owner can see the changes made in project details
            // get back to home page
            driver.get(baseURL);
            System.out.println("Testcase pass");
        }catch(Exception e){
            System.out.println("Exception generated in test2 ");
            System.out.println("Expected title : " + expectedTitle);
            System.out.println("Actual title : " + driver.getTitle());
            //e.printStackTrace();
            Assert.fail();

        }
    }
    //***Verify project owner can post a new project**/
    @Parameters({"projectName","projectDes"})
    @Test(enabled = false)//(priority = 3)
        public void test3(String projectName,String projectDes) throws InterruptedException {
        try {
            homepage.clickOnPostNewProjectTab();
            Thread.sleep(5000);
            projectFactory.fillProjectTitle(projectName);
            projectFactory.fillProjectDescription(projectDes);
            projectFactory.selectSkillsAndCat();
            projectFactory.fillProjectBudget(2);
            projectFactory.fillProjectEndingDate("");
            projectFactory.fillProjectCountry(2);
            projectFactory.fillProjectLocationAddress("123");
            projectFactory.clickOnProjectSubmit1();
            projectFactory.clickOnProjectSubmit2();
            Thread.sleep(4000);
            projectFactory.clickOnNextStep();
            projectFactory.selectTermsCheckBox();
            projectFactory.clickOnPayByCreditsButton();
            projectFactory.clickOnPayNowButton();
            //Thread.sleep(4000);
            projectFactory.clickOnGoToYourAccountLink();
        } catch (Exception e) {
            System.out.println("Exception generated in test3 ");
            e.printStackTrace();
            Assert.fail(); // or throw e
        }
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
