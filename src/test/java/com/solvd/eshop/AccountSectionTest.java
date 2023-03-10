package com.solvd.eshop;

import com.solvd.eshop.page.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountSectionTest extends AbstractTest {

    @Test(testName = "verify that registration success with new email", enabled = false)
    public void verifyValidRegistrationTest() {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        RegistrationPage registrationPage = loginPage.clickRegistrationButton();
        int num = (int) (Math.random() * 99999);
        registrationPage.typeEmail("freppeumeproifei-" + num + "@yopmail.com");
        RegistrationPrivacyPage registrationPrivacyPage = registrationPage.clickContinueButton();
        SuccessRegistrationPage successRegistrationPage = registrationPrivacyPage.clickPrivacyButton();
        String successMessage = successRegistrationPage.getSuccessRegistration().getText();
        Assert.assertEquals(successMessage, "Вы зарегистрированы", "Registration success message wasn't displayed");
    }

    @Test(testName = "verify enter into account", enabled = false)
    public void verifyEnterIntoAccountTest() {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickCookieButton();
        homePage.clickAccountMenu();
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.typeLoginEmail("freppeumeproiffei-9147@yopmail.com");
        loginPage.typeLoginPassword("7a5a23b6");
        homePage = loginPage.clickEnterButton();
        homePage.clickAccountMenuAfterLogin();
        String accountEmail = homePage.getAccountInfo();
        Assert.assertEquals(accountEmail, "freppeumeproiffei-9147@yopmail.com", "Login is failed");
    }
}