package com.solvd.eshop;

import com.solvd.eshop.elements.ProductMenuBar;
import com.solvd.eshop.page.BrandProductPage;
import com.solvd.eshop.page.ProductPage;
import com.solvd.eshop.page.HomePage;
import com.solvd.eshop.page.ResultPage;
import com.solvd.eshop.elements.SearchSection;
import com.solvd.eshop.utils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    @DataProvider(name = "productBrandData")
    public Object[][] dataBrand() {
        return new Object[][]{
                {"Холодильники", "LG"}
        };
    }

    @DataProvider(name = "productPrice")
    public Object[][] dataPrice() {
        return new Object[][]{
                {"Смартфоны", "400", "450"},
                {"Пылесосы", "700", "800"}
        };
    }

    @BeforeTest
    public void beforeTestSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethodSetup() {
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigFileReader.getData("url"));
        webDriver.set(driver);
    }

    @Test(testName = "verify that results contains input text")
    public void verifySearchTextTypeResultsTest() {
        HomePage homePage = new HomePage(webDriver.get());
        homePage.clickCookieButton();
        SearchSection searchSection = new SearchSection(webDriver.get());
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
        HomePage homePage = new HomePage(webDriver.get());
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = new ProductMenuBar(webDriver.get());
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
        HomePage homePage = new HomePage(webDriver.get());
        homePage.clickCookieButton();
        ProductMenuBar productMenuBar = new ProductMenuBar(webDriver.get());
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

    @AfterMethod(alwaysRun = true)
    public void afterMethodSetup() {
        webDriver.get().close();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestSetup() {
        WebDriverManager.chromedriver().quit();
    }
}
