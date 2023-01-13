package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(css = ".style_inputStyle__1dvyw")
    private WebElement emailField;

    @FindBy(css = ".styles_registerButton__18sPZ")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        waitIsClickable(5, emailField);
        typeText(emailField, email);
    }

    public RegistrationPrivacyPage clickContinueButton() {
        waitIsClickable(5, continueButton);
        if (continueButton.isDisplayed()) {
            elementClick(continueButton);
        }
        return new RegistrationPrivacyPage(driver);
    }
}
