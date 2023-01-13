package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPrivacyPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='styles_buttons__3IGzu']//*[contains(text(),'Соглашаюсь')]")
    private WebElement privacyButton;

    public RegistrationPrivacyPage(WebDriver driver) {
        super(driver);
    }

    public SuccessRegistrationPage clickPrivacyButton() {
        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage(driver);
        waitIsClickable(5, privacyButton);
        if (privacyButton.isDisplayed()) {
            elementClick(privacyButton);
        }
        return successRegistrationPage;
    }
}
