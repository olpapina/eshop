package com.solvd.eshop.elements;

import com.solvd.eshop.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductMenuBar extends ProductPage {

    @FindBy(css = ".styles_promoItem__3H-t7")
    private List<WebElement> itemProducts;

    public ProductMenuBar(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(String productName) {
        WebElement requiredProduct = itemProducts.stream()
                .filter(product -> product.getText().equals(productName))
                .findFirst()
                .orElseThrow();
        waitIsClickable(20, requiredProduct);
        requiredProduct.click();
        return new ProductPage(driver);
    }
}
