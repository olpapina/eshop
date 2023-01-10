package com.solvd.eshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(css = ".styles_reactButton__2olKd")
    private WebElement cookieButton;
    @FindBy(css = ".styles_userToolsToggler__imcSl")
    private WebElement accountMenu;
    @FindBy(css = ".userToolsBtn")
    private WebElement loginButton;
    @FindBy(xpath = "//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]")
    private WebElement registrationButton;
    @FindBy(css = ".style_inputStyle__1dvyw")
    private WebElement emailField;
    @FindBy (css = ".styles_registerButton__18sPZ")
    private WebElement continueButton;
    @FindBy (xpath = "//*[@class='styles_buttons__3IGzu']//*[contains(text(),'Соглашаюсь')]")
    private WebElement privacyButton;
    @FindBy (css = ".styles_successTitle__1IDi2")
    private WebElement successRegistration;
    @FindBy (css = "#login-email")
    private WebElement loginEmail;
    @FindBy (css = "#login-password")
    private WebElement loginPassword;
    @FindBy (css = ".style_actions__2mIsz")
    private WebElement enterButton;
    @FindBy (css = ".userToolsSubtitle")
    private WebElement accountEmail;
    @FindBy (css = ".styles_userTools__2J7cp.undefined")
    private WebElement accountMenuAfterLogin;
    @FindBy (css = ".styles_catalogButton__1K6kI")
    private WebElement catalogButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver,Duration.ofMillis(1000));
        PageFactory.initElements(driver, this);
    }

    public void clickCookieButton() {
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

    public void clickAccountMenu() {
        if (accountMenu.isDisplayed()) {
            accountMenu.click();
        }
    }

        public void clickLoginButton() {
            waiter.until(ExpectedConditions.elementToBeClickable(loginButton));
            if (loginButton.isDisplayed()) {
                loginButton.click();
            }
        }

    public void clickRegistrationButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(registrationButton));
        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        }
    }

    public void typeEmail(String email) {
        waiter.until(ExpectedConditions.elementToBeClickable(emailField));
            emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(continueButton));
        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
    }

    public WebElement clickPrivacyButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(privacyButton));
        if (privacyButton.isDisplayed()) {
            privacyButton.click();
        }
        waiter.until(ExpectedConditions.elementToBeClickable(successRegistration));
        return successRegistration;
    }

    public void typeLoginEmail(String email) {
        waiter.until(ExpectedConditions.elementToBeClickable(loginEmail));
        if (loginEmail.isDisplayed()) {
            loginEmail.sendKeys(email);
        }
    }

    public void typeLoginPassword(String password) {
        waiter.until(ExpectedConditions.elementToBeClickable(loginPassword));
        if (loginPassword.isDisplayed()) {
            loginPassword.sendKeys(password);
        }
    }

    public void clickEnterButton() {
        waiter.until(ExpectedConditions.elementToBeClickable(enterButton));
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
    }

    public void clickAccountMenuAfterLogin() {
        waiter.until(ExpectedConditions.elementToBeClickable(accountMenuAfterLogin));
        if (accountMenuAfterLogin.isDisplayed()) {
            accountMenuAfterLogin.click();
        }
    }

    public String getAccountInfo() {
        waiter.until(ExpectedConditions.elementToBeClickable(accountEmail));
        return accountEmail.getText();
    }
}
