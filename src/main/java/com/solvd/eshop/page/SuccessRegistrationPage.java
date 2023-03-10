package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessRegistrationPage extends AbstractPage {
    @FindBy(css = ".styles_successTitle__1IDi2")
    private WebElement successRegistration;

    public SuccessRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSuccessRegistration() {
        waitIsClickable(5, successRegistration);
        return successRegistration;
    }
}
