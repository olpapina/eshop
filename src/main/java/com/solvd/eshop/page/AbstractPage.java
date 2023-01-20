package com.solvd.eshop.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void elementClick(WebElement webElement, long second) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        if (webElement.isDisplayed()) {
            webElement.click();
            LOGGER.info(webElement.getTagName() + " is clicked");
        } else {
            LOGGER.error(webElement.getTagName() + " isn't clicked");
        }
    }

    public void typeText(WebElement webElement, String text, long second) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
        webElement.sendKeys(text);
        LOGGER.info("in the " + webElement.getAccessibleName() + "text" + text + "was typed");
    }

    public String getElementText(WebElement webElement) {
        return webElement.getText();
    }
}
