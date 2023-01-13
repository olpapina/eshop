package com.solvd.eshop.page;

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

    @FindBy (css = ".styles_userTools__2J7cp.undefined")
    private WebElement accountMenuAfterLogin;

    @FindBy(css = ".userToolsSubtitle")
    private WebElement userToolsTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
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

    public LoginPage clickLoginButton() {
        waiteIsClickable(5, loginButton);
        if (loginButton.isDisplayed()) {
            loginButton.click();
        }
        return new LoginPage(driver);
    }

    public void clickAccountMenuAfterLogin() {
        waiteIsClickable(5, accountMenuAfterLogin);
        if (accountMenuAfterLogin.isDisplayed()) {
            accountMenuAfterLogin.click();
        }
    }

    public String getAccountInfo() {
        waiteIsClickable(5, userToolsTitle);
        return userToolsTitle.getText();
    }
}
