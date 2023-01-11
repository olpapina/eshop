package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessRegistrationPage {
    protected WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(css = ".styles_successTitle__1IDi2")
    private WebElement successRegistration;

    public SuccessRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofMillis(1000));
        PageFactory.initElements(driver, this);
    }

    public WebElement getSuccessRegistration() {
        waiter.until(ExpectedConditions.elementToBeClickable(successRegistration));
        return successRegistration;
    }

}
