package com.solvd.eshop.elements;

import com.solvd.eshop.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@FindBy(css = ".styles_headerReactLine__IWu_8 styles_headerReactLineSecond__tp1U0")
public class SearchSection {
    protected WebDriver driver;

    @FindBy(css = "#catalogSearch")
    private WebElement searchField;

    @FindBy(css = ".Search_searchBtn__3fSOy")
    private WebElement searchButton;

    public SearchSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waiteIsClickable(long second, WebElement webElement) {
        new WebDriverWait(this.driver, Duration.ofSeconds(second))
                .until((ExpectedConditions.elementToBeClickable(webElement)));
    }

    public void typeTextInSearch(String searchText) {
        waiteIsClickable(5, searchField);
        searchField.sendKeys(searchText);
    }

    public ResultPage clickSearchButton() {
        waiteIsClickable(5, searchButton);
        if (searchButton.isDisplayed()) {
            searchButton.click();
        }
        return new ResultPage(driver);
    }
}
