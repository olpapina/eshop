package com.solvd.eshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    protected WebDriver driver;

    @FindBy(css = ".result__name")
    List<WebElement> searchResultItems;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getFullNames() {
        return searchResultItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
