package com.solvd.eshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setupBeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
    }

    @Test(testName = "verify that registration success with new email")
    public void verifySearchTextTypeResultsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.typeTextInSearch("Ломтерезка");
        homePage.clickSearchButton();
    }
//
//    @AfterMethod(alwaysRun = true)
//    public void setupAfterMethod() {
//        driver.close();
//    }
}
