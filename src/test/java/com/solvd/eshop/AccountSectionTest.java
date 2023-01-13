package com.solvd.eshop;

import com.solvd.eshop.page.*;
import com.solvd.eshop.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountSectionTest {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @BeforeTest
    public void beforeTestSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethodSetup() {
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        webDriver.set(driver);
    }

    @Test(testName = "verify that registration success with new email")
    public void verifyValidRegistrationTest() {
        HomePage homePage = new HomePage(webDriver.get());
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        int num = (int) (Math.random() * 99999);
        registrationPage.typeEmail("freppeumeproiffei-" + num + "@yopmail.com");
        RegistrationPrivacyPage registrationPrivacyPage = registrationPage.clickContinueButton();
        SuccessRegistrationPage successRegistrationPage = registrationPrivacyPage.clickPrivacyButton();
        String successMessage = successRegistrationPage.getSuccessRegistration().getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
    }

    @Test(testName = "verify enter into account")
    public void verifyEnterIntoAccountTest() {
        HomePage homePage = new HomePage(webDriver.get());
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeLoginEmail("freppeumeproiffei-9147@yopmail.com");
        loginPage.typeLoginPassword("7a5a23b6");
        homePage = loginPage.clickEnterButton();
        homePage.clickAccountMenuAfterLogin();
        String accountEmail = homePage.getAccountInfo();
        Assert.assertEquals(accountEmail, "freppeumeproiffei-9147@yopmail.com", "Login is failed");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup() {
        webDriver.get().close();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestSetup() {
        WebDriverManager.chromedriver().quit();
    }
}
