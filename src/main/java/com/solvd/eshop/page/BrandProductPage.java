package com.solvd.eshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BrandProductPage extends AbstractPage {

    @FindBy(css = ".result__link j-ga_track .result__name")
    List<WebElement> brandProducts;

    @FindBy(xpath = "//*[contains(@class,'cr-result__full')]//*[contains(@class,'result__price')]//*[contains(@class,'j-item-data')]")
    List<WebElement> productPrices;

    public BrandProductPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getFullNames() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return brandProducts.stream()
                .map(this::getElementText).collect(Collectors.toList());
    }

    public List<String> getResultPrices() {
        new WebDriverWait(this.driver, Duration.ofSeconds(30))
                .until((ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".result__name"))));
        return productPrices.stream()
                .map(this::getElementText).collect(Collectors.toList());
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
