package com.solvd.eshop.elements;

import com.solvd.eshop.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@FindBy(css = ".styles_headerReactWrapper__3U15a styles_headerReactWrapperAlt__3bM5y")
public class ProductMenuBar {
    protected WebDriver driver;

    @FindBy(css = ".styles_promoItem__3H-t7")
    private List<WebElement> itemProducts;

    public ProductMenuBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public ProductPage selectProduct(String productName) {
        WebElement requiredProduct = itemProducts.stream()
                .filter(product -> product.getText().equals(productName))
                .findFirst()
                .orElseThrow();
        waiteIsClickable(20, requiredProduct);
        requiredProduct.click();
        return new ProductPage(driver);
    }
}
