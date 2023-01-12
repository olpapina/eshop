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
        private WebDriverWait waiter;

        @FindBy(css = ".styles_reactButton__2olKd")
        private WebElement cookieButton;

        @FindBy(css = ".styles_userToolsToggler__imcSl")
        private WebElement accountMenu;

        @FindBy(css = ".userToolsBtn")
        private WebElement loginButton;


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

        public LoginPage clickLoginButton() {
            LoginPage loginPage = new LoginPage(driver);
            waiter.until(ExpectedConditions.elementToBeClickable(loginButton));
            if (loginButton.isDisplayed()) {
                loginButton.click();
            }
            return loginPage;
        }
}
