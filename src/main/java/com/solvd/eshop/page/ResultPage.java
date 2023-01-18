package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends AbstractPage {
    @FindBy(css = ".result__name")
    private List<WebElement> searchResultItems;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getFullNames() {
        return searchResultItems.stream()
                .map(this::getElementText)
                .collect(Collectors.toList());
    }
}
