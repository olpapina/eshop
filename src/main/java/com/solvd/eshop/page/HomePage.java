package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

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
        super(driver);
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
        waitIsClickable(5, loginButton);
        if (loginButton.isDisplayed()) {
            loginButton.click();
        }
        return new LoginPage(driver);
    }

    public void clickAccountMenuAfterLogin() {
        waitIsClickable(5, accountMenuAfterLogin);
        if (accountMenuAfterLogin.isDisplayed()) {
            accountMenuAfterLogin.click();
        }
    }

    public String getAccountInfo() {
        waitIsClickable(5, userToolsTitle);
        return userToolsTitle.getText();
    }
}
