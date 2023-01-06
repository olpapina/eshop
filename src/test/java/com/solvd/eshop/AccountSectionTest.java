package com.solvd.eshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountSectionTest {
    @Test
    public void verifyValidRegistrationTest () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by");
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        homePage.clickLoginButton();
        homePage.clickRegistrationButton();
        homePage.typeEmail("freppeumeproiffei-9149@yopmail.com");
        homePage.clickContinueButton();
        driver.close();
    }
}
