package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    protected WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(css = ".style_inputStyle__1dvyw")
    private WebElement emailField;

    @FindBy (css = ".styles_registerButton__18sPZ")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofMillis(1000));
        PageFactory.initElements(driver, this);
    }

    public void typeEmail(String email) {
        waiter.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.sendKeys(email);
    }

    public RegistrationPrivacyPage clickContinueButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(continueButton));
        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
        return  new RegistrationPrivacyPage(driver);
    }
}
