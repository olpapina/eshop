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
        elementClick(registrationButton, 5);
        return new RegistrationPage(driver);
    }

    public void typeLoginEmail(String email) {
        typeText(emailField, email, 5);
    }

    public void typeLoginPassword(String password) {
        typeText(passwordField, password, 5);
    }

    public HomePage clickEnterButton() {
        elementClick(enterButton, 5);
        return new HomePage(driver);
    }
}
