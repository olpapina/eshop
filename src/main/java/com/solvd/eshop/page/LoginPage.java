package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(xpath = "//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]")
    private WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofMillis(1000));
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickRegistrationButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(registrationButton));
        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        }
        return new RegistrationPage(driver);
    }
}
