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

    @FindBy(xpath = "//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]")
    private WebElement registrationButton;

    @FindBy(css = "#login-email")
    private WebElement emailField;

    @FindBy(css = "#login-password")
    private WebElement passwordField;

    @FindBy(css = ".style_actions__2mIsz .style_baseActionButton__2LQYJ ")
    private WebElement enterButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public RegistrationPage clickRegistrationButton() {
        waiteIsClickable(5, registrationButton);
        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        }
        return new RegistrationPage(driver);
    }

    public void typeLoginEmail(String email) {
        waiteIsClickable(5, emailField);
        emailField.sendKeys(email);
    }

    public void typeLoginPassword(String password) {
        waiteIsClickable(5, passwordField);
        passwordField.sendKeys(password);
    }

    public HomePage clickEnterButton() {
        waiteIsClickable(5, enterButton);
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
        return new HomePage(driver);
    }
}
