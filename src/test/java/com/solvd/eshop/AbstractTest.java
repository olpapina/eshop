package com.solvd.eshop;

import com.solvd.eshop.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.FailedReporter;

public abstract class AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);
    private static final ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();

    @BeforeTest
    public void beforeTestSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethodSetup() {
        WebDriver driver = new ChromeDriver();
        LOGGER.info("21vek.by is opening");
        driver.get(ConfigFileReader.getData("url"));
        webDriver.set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup(ITestResult result) {
        if (result.getStatus()==ITestResult.FAILURE) {
            LOGGER.error(result.getName()+ " is failed");
        }
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
