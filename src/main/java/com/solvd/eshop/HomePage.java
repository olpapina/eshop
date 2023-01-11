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
    @FindBy (css = "#catalogSearch")
    private WebElement searchField;
    @FindBy (css = ".Search_searchBtn__3fSOy")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long seconds, WebElement webElement) {
        new WebDriverWait(driver,Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void clickCookieButton() {
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

    public void clickAccountMenu() {
        waiteIsClickable(5,accountMenu);
        if (accountMenu.isDisplayed()) {
            accountMenu.click();
        }
    }

        public void clickLoginButton() {
            waiteIsClickable(10,loginButton);
            if (loginButton.isDisplayed()) {
                loginButton.click();
            }
        }

    public void clickRegistrationButton() {
        waiteIsClickable(5,registrationButton);
        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        }
    }

    public void typeEmail(String email) {
        waiteIsClickable(5,emailField);
        emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        waiteIsClickable(5, continueButton);
        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
    }

    public WebElement clickPrivacyButton() {
        waiteIsClickable(5, privacyButton);
        if (privacyButton.isDisplayed()) {
            privacyButton.click();
        }
        waiteIsClickable(5, successRegistration);
        return successRegistration;
    }

    public void typeLoginEmail(String email) {
        waiteIsClickable(5, loginEmail);
        if (loginEmail.isDisplayed()) {
            loginEmail.sendKeys(email);
        }
    }

    public void typeLoginPassword(String password) {
        waiteIsClickable(5, loginPassword);
        if (loginPassword.isDisplayed()) {
            loginPassword.sendKeys(password);
        }
    }

    public void clickEnterButton() {
        waiteIsClickable(5, enterButton);
        if (enterButton.isDisplayed()) {
            enterButton.click();
        }
    }

    public void clickAccountMenuAfterLogin() {
        waiteIsClickable(10, accountMenuAfterLogin);
        if (accountMenuAfterLogin.isDisplayed()) {
            accountMenuAfterLogin.click();
        }
    }

    public String getAccountInfo() {
        waiteIsClickable(5, accountEmail);
        return accountEmail.getText();
    }

    public void typeTextInSearch(String string) {
        waiteIsClickable(5,searchField);
        searchField.sendKeys(string);
    }

    public void clickSearchButton() {
        waiteIsClickable(10, searchButton);
        if (searchButton.isDisplayed()) {
            searchButton.click();
        }
    }
}
