package com.solvd.eshop.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
                .filter(checkbox -> getElementText(checkbox).equals(brand))
                .findFirst()
                .orElseThrow();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requiredCheckbox);
        elementClick(requiredCheckbox, 10);
    }

    public BrandProductPage clickShowProductsButton() {
        elementClick(showProductsButton, 20);
        return new BrandProductPage(driver);
    }

    public void typeMinPriceField(String minPrice) {
        typeText(minPriceField,minPrice, 10);
    }

    public void typeMaxPriceField(String maxPrice) {
        typeText(maxPriceField,maxPrice, 10);
    }
}