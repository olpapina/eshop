package com.solvd.eshop.elements;

import com.solvd.eshop.page.AbstractPage;
import com.solvd.eshop.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductMenuBar extends AbstractPage {

    @FindBy(css = ".styles_promoItem__3H-t7")
    private List<WebElement> itemProducts;

    public ProductMenuBar(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(String productName) {
        WebElement requiredProduct = itemProducts.stream()
                .filter(product -> getElementText(product).equals(productName))
                .findFirst()
                .orElseThrow();
        elementClick(requiredProduct, 5);
        return new ProductPage(driver);
    }
}
