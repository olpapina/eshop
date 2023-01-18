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
            elementClick(cookieButton,0);
        }
    }

    public void clickAccountMenu() {
        if (accountMenu.isDisplayed()) {
            elementClick(accountMenu,0);
        }
    }

    public LoginPage clickLoginButton() {
        if (loginButton.isDisplayed()) {
            elementClick(loginButton,5);
        }
        return new LoginPage(driver);
    }

    public void clickAccountMenuAfterLogin() {
        if (accountMenuAfterLogin.isDisplayed()) {
            elementClick(accountMenuAfterLogin, 5);
        }
    }

    public String getAccountInfo() {
        waitIsClickable(5, userToolsTitle);
        return getElementText(userToolsTitle);
    }
}
