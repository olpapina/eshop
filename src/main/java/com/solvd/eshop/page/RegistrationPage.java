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

    @FindBy(css = ".style_inputStyle__1dvyw")
    private WebElement emailField;

    @FindBy(css = ".styles_registerButton__18sPZ")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public void typeEmail(String email) {
        waiteIsClickable(5, emailField);
        emailField.sendKeys(email);
    }

    public RegistrationPrivacyPage clickContinueButton() {
        waiteIsClickable(5, continueButton);
        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
        return new RegistrationPrivacyPage(driver);
    }
}
