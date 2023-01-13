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

    @FindBy(xpath = "//*[@class='styles_buttons__3IGzu']//*[contains(text(),'Соглашаюсь')]")
    private WebElement privacyButton;

    public RegistrationPrivacyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public SuccessRegistrationPage clickPrivacyButton() {
        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage(driver);
        waiteIsClickable(5, privacyButton);
        if (privacyButton.isDisplayed()) {
            privacyButton.click();
        }
        return successRegistrationPage;
    }
}
