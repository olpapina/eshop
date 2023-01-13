package com.solvd.eshop;

import com.solvd.eshop.elements.ProductMenuBar;
import com.solvd.eshop.page.BrandProductPage;
import com.solvd.eshop.page.ProductPage;
import com.solvd.eshop.page.HomePage;
import com.solvd.eshop.page.ResultPage;
import com.solvd.eshop.elements.SearchSection;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest extends AbstractTest {
    @DataProvider(name = "productBrandData")
    public Object[][] dataBrand() {
        return new Object[][]{
                {"Холодильники", "LG"},
                {"Пылесосы", "Karcher"}
        };
    }

    @DataProvider(name = "productPrice")
    public Object[][] dataPrice() {
        return new Object[][]{
                {"Смартфоны", "400", "450"}
        };
    }

    @Test(testName = "verify that results contains input text")
    public void verifySearchTextTypeResultsTest() {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickCookieButton();
        SearchSection searchSection = new SearchSection(getWebdriver());
        String inputText = "Ломтерезка";
        searchSection.typeTextInSearch(inputText);
        ResultPage resultPage = searchSection.clickSearchButton();
        List<String> fullNames = resultPage.getFullNames();

        SoftAssert sa = new SoftAssert();
        fullNames.forEach(name -> sa.assertTrue(name.contains(inputText), "The result doesn't have " + inputText + " in the name"));
        sa.assertAll();
    }

    @Test(testName = "verify advance search that product brand will be found in results", dataProvider = "productBrandData")
    public void verifyAdvanceSearchItemBrandTest(String product, String brand) {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = new ProductMenuBar(getWebdriver());
        ProductPage productPage = productMenuBar.selectProduct(product);
        productPage.selectCheckbox(brand);
        BrandProductPage brandProductPage = productPage.clickShowProductsButton();
        List<String> resultNames = brandProductPage.getFullNames();

        SoftAssert sa = new SoftAssert();
        resultNames.forEach(resultName -> sa.assertTrue(resultName.contains(brand), "The result doesn't have " + brand + " in the name"));
        sa.assertAll();
    }

    @Test(testName = "verify advance search that product price in selected interval", dataProvider = "productPrice")
    public void verifyAdvanceSearchPriceOfResultTest(String product, String minPrice, String maxPrice) {
        HomePage homePage = new HomePage(getWebdriver());
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = new ProductMenuBar(getWebdriver());
        ProductPage productPage = productMenuBar.selectProduct(product);
        productPage.typeMinPriceField(minPrice);
        productPage.typeMaxPriceField(maxPrice);
        BrandProductPage brandProductPage = productPage.clickShowProductsButton();
        List<String> resultPrices = brandProductPage.getResultPrices();
        List<Double> prices = brandProductPage.getPrices(resultPrices);

        SoftAssert sa = new SoftAssert();
        prices.forEach(price -> {
            sa.assertTrue(price > Double.parseDouble(minPrice), "The result price less minimum price");
            sa.assertTrue(price < Double.parseDouble(maxPrice), "The result price more maximum price");
        });
        sa.assertAll();
    }
}
