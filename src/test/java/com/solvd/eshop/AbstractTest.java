package com.solvd.eshop;

import com.solvd.eshop.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {
    private static final ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();

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

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup() {
        webDriver.get().close();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestSetup() {
        WebDriverManager.chromedriver().quit();
    }

    public WebDriver getWebdriver() {
        return webDriver.get();
    }
}
