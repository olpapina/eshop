package com.solvd.eshop;

import com.solvd.eshop.utils.ConfigFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.solvd.eshop.utils.CapabilityFactory.getCapabilities;

public abstract class AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);
    private static final ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethodSetup(String browser) throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(new URL(ConfigFileReader.getData("nodeUrl")), getCapabilities(browser));
        driver.get(ConfigFileReader.getData("baseUrl"));
        LOGGER.info("21vek.by is opening");
        webDriver.set(driver);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = new Date();
        String strDate = dateFormat.format(date.getTime());
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath + strDate + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup(ITestResult result) throws Exception {
        if (result.getStatus()==ITestResult.FAILURE) {
            takeSnapShot(webDriver.get(), ConfigFileReader.getData("screenShotsPath"));
            throw new IOException(result.getName()+ " is failed");
        }
        webDriver.get().close();
    }

    public WebDriver getWebdriver() {
        return webDriver.get();
    }
}
