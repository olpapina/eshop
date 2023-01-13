package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]")
    private WebElement registrationButton;

    @FindBy(css = "#login-email")
    private WebElement emailField;

    @FindBy(css = "#login-password")
    private WebElement passwordField;

    @FindBy(css = ".style_actions__2mIsz .style_baseActionButton__2LQYJ ")
    private WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage clickRegistrationButton() {
        waitIsClickable(5, registrationButton);
        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        }
        return new RegistrationPage(driver);
    }

    public void typeLoginEmail(String email) {
        waitIsClickable(5, emailField);
        emailField.sendKeys(email);
    }

    public void typeLoginPassword(String password) {
        waitIsClickable(5, passwordField);
        passwordField.sendKeys(password);
    }

    public HomePage clickEnterButton() {
        waitIsClickable(5, enterButton);
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
        return new HomePage(driver);
    }
}
