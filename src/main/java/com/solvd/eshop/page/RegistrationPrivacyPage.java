package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPrivacyPage {
    protected WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(xpath = "//*[@class='styles_buttons__3IGzu']//*[contains(text(),'Соглашаюсь')]")
    private WebElement privacyButton;

    public RegistrationPrivacyPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofMillis(1000));
        PageFactory.initElements(driver, this);
    }

    public SuccessRegistrationPage clickPrivacyButton() {
        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage(driver);
        waiter.until(ExpectedConditions.elementToBeClickable(privacyButton));
        if (privacyButton.isDisplayed()) {
            privacyButton.click();
        }
        return successRegistrationPage;
    }
}
