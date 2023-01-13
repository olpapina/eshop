package com.solvd.eshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrandProductPage {
    protected WebDriver driver;

    @FindBy(css = ".result__link j-ga_track .result__name")
    List<WebElement> brandProducts;

    @FindBy(xpath = "//*[contains(@class,'cr-result__full')]//*[contains(@class,'result__price')]//*[contains(@class,'j-item-data')]")
    List<WebElement> productPrices;

    public BrandProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public List<String> getFullNames() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return brandProducts.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getResultPrices() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return productPrices.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Double> getPrices(List<String> resultPrices) {
        List<String> newResultPrices = resultPrices.stream()
                .map(price-> price.replace(',','.'))
                .collect(Collectors.toList());
        return newResultPrices.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
