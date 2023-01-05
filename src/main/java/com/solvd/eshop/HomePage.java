package com.solvd.eshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    private By cookieBanerBy = By.cssSelector("//*[@class='styles_agreementWrapper__3VVtf']" +
            "//*[contains(@class,'styles_button__2N0fI')]");
    public HomePage(WebDriver driver){
        this.driver = driver;

}
