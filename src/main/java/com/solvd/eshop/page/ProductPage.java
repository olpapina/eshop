package com.solvd.eshop.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends AbstractPage {
    @FindBy(css = ".l-filter b-sidebar")
    WebElement sideBar;

    @FindBy(xpath = "//*[contains(@class,'filter__attrs cr-filter__producers')]//*[contains(@class,'j-plus__toggle g-pseudo_href')]")
    WebElement showAll;

    @FindBy(xpath = "//*[contains(@class, 'filter__attrs cr-filter__producers')]//*[@class='filter-attr__value']")
    List<WebElement> checkboxes;

    @FindBy(css = "#j-filter__btn")
    WebElement showProductsButton;

    @FindBy(xpath = "//*[contains(@class,'cr-filter__price')]//*[@class='g-form__inputwrap']//*[@name='filter[price][from]']")
    WebElement minPriceField;

    @FindBy(xpath = "//*[contains(@class,'cr-filter__price')]//*[@class='g-form__inputwrap']//*[@name='filter[price][to]']")
    WebElement maxPriceField;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectCheckbox(String brand) {
        WebElement requiredCheckbox = checkboxes.stream()
                .filter(checkbox -> checkbox.getText().equals(brand))
                .findFirst()
                .orElseThrow();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requiredCheckbox);
        waitIsClickable(10, requiredCheckbox);
        requiredCheckbox.click();
    }

    public BrandProductPage clickShowProductsButton() {
        waitIsClickable(30, showProductsButton);
        showProductsButton.click();
        return new BrandProductPage(driver);
    }

    public void typeMinPriceField(String minPrice) {
        waitIsClickable(10, minPriceField);
        minPriceField.sendKeys(minPrice);
    }

    public void typeMaxPriceField(String maxPrice) {
        waitIsClickable(10, maxPriceField);
        maxPriceField.sendKeys(maxPrice);
    }
}