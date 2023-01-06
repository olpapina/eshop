package com.solvd.eshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;

    private By cookieButtonBy = By.cssSelector(".styles_reactButton__2olKd");
    private By accountMenuBy = By.cssSelector(".userToolsText");
    private By loginButtonBy = By.cssSelector(".userToolsBtn");
    private By registrationButtonBy = By.xpath("//*[contains(@class,'styles_bottomLinks__349w0')]//*[contains(text(),'Регистрация')]");
    private By emailFieldBy = By.cssSelector(".style_inputStyle__1dvyw");
    private By continueButtonBy = By.cssSelector(".styles_registerButton__18sPZ");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButtonBy).click();
    }

    public void clickAccountMenu() {
        driver.findElement(accountMenuBy).click();
    }

    public void  clickLoginButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(loginButtonBy).click();
    }

    public void clickRegistrationButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(registrationButtonBy).click();
    }

    public void typeEmail(String email) {
        driver.findElement(emailFieldBy).sendKeys(email);
    }

    public void clickContinueButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(continueButtonBy).click();
    }
}
