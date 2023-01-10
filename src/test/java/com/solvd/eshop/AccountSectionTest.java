package com.solvd.eshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountSectionTest {
    WebDriver driver;
    ConfigFileReader configFileReader;

    @BeforeTest
    public void setupBeforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
    }

    @Test(testName = "verify that registration success with new email")
    public void verifyValidRegistrationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountMenu();
        homePage.clickLoginButton();
        homePage.clickRegistrationButton();
        int num = (int)(Math.random() *9999);
        homePage.typeEmail("freppeumeproiffei-" + Integer.toString(num) + "@yopmail.com");
        homePage.clickContinueButton();
        WebElement newSuccessRegistration = homePage.clickPrivacyButton();
        String successMessage = newSuccessRegistration.getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
    }

    @AfterTest(alwaysRun = true)
    public void setupAfterTest() {
        driver.close();
    }
}
