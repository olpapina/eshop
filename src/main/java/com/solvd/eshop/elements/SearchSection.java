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

        typeText(searchField, searchText, 5);
    }

    public ResultPage clickSearchButton() {
        elementClick(searchButton, 5);
        return new ResultPage(driver);
    }
}
