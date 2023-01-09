package com.solvd.eshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountSectionTest {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.21vek.by");
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
    }

    @Test(testName = "verify that registration success with new email")
    public void verifyValidRegistrationTest () {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountMenu();
        homePage.clickLoginButton();
        homePage.clickRegistrationButton();
        homePage.typeEmail("freppeumeproiffei-9159@yopmail.com");
        homePage.clickContinueButton();
        By newSuccessRegistration = homePage.clickPrivacyButton();
        Assert.assertNotNull(newSuccessRegistration, "Registration isn't completed");
        driver.close();
    }
}
