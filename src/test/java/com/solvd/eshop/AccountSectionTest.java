package com.solvd.eshop;

import com.solvd.eshop.page.*;
import com.solvd.eshop.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountSectionTest {

    @BeforeTest
    public void beforeTestSetup () {
        WebDriverManager.chromedriver().setup();
    }

    @Test(testName = "verify that registration success with new email")
    public void verifyValidRegistrationTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        int num = (int)(Math.random() *99999);
        registrationPage.typeEmail("freppeumeproiffei-" + Integer.toString(num) + "@yopmail.com");
        RegistrationPrivacyPage registrationPrivacyPage = registrationPage.clickContinueButton();
        SuccessRegistrationPage successRegistrationPage = registrationPrivacyPage.clickPrivacyButton();
        String successMessage = successRegistrationPage.getSuccessRegistration().getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
        driver.close();
    }

    @Test(testName = "verify enter into account")
    public void verifyEnterIntoAccountTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeLoginEmail("freppeumeproiffei-9147@yopmail.com");
        loginPage.typeLoginPassword("7a5a23b6");
        homePage = loginPage.clickEnterButton();
        homePage.clickAccountMenuAfterLogin();
        String accountEmail = homePage.getAccountInfo();
        Assert.assertEquals(accountEmail, "freppeumeproiffei-9147@yopmail.com", "Login is failed");
        driver.close();
    }

    @AfterMethod(alwaysRun = true)
    public void setupAfterMethod() {
        WebDriverManager.chromedriver().quit();
    }
}