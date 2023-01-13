package com.solvd.eshop.elements;

import com.solvd.eshop.page.AbstractPage;
import com.solvd.eshop.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchSection extends AbstractPage {
    @FindBy(css = "#catalogSearch")
    private WebElement searchField;

    @FindBy(css = ".Search_searchBtn__3fSOy")
    private WebElement searchButton;

    public SearchSection(WebDriver driver) {
        super(driver);
    }

    public void typeTextInSearch(String searchText) {
        waitIsClickable(5, searchField);
        searchField.sendKeys(searchText);
    }

    public ResultPage clickSearchButton() {
        waitIsClickable(5, searchButton);
        if (searchButton.isDisplayed()) {
            searchButton.click();
        }
        return new ResultPage(driver);
    }
}
