package com.solvd.eshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountSectionTest {

    WebDriver driver;
//    HomePage homePage;

//    @BeforeTest
//    public void setupBeforeTest() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod
    public void setupBeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
//        Home homePage = new HomePage(driver);
//        homePage.clickCookieButton();
    }

    @Test(testName = "verify that registration success with new email")
    public void verifyValidRegistrationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountMenu();
        homePage.clickLoginButton();
        homePage.clickRegistrationButton();
        int num = (int) (Math.random() * 9999);
        homePage.typeEmail("freppeumeproiffei-" + Integer.toString(num) + "@yopmail.com");
        homePage.clickContinueButton();
        WebElement newSuccessRegistration = homePage.clickPrivacyButton();
        String successMessage = newSuccessRegistration.getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
    }

    @Test(testName = "verify enter into account")
    public void verifyEnterIntoAccountTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountMenu();
        homePage.clickLoginButton();
        homePage.typeLoginEmail("freppeumeproiffei-9147@yopmail.com");
        homePage.typeLoginPassword("7a5a23b6");
        homePage.clickEnterButton();
        homePage.clickAccountMenuAfterLogin();
        String accountEmail = homePage.getAccountInfo();
        Assert.assertEquals(accountEmail, "freppeumeproiffei-9147@yopmail.com", "Login is failed");
    }


//
//    @AfterMethod(alwaysRun = true)
//    public void setupAfterMethod() {
//        driver.close();
//    }
//
    @AfterTest(alwaysRun = true)
    public void setupAfterTest() {
        driver.close();
    }
}