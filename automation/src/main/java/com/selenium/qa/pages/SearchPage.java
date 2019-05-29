package com.selenium.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(id = "twotabsearchtextbox")
    static WebElement searchBar;
    @FindBy(className = "nav-input")
    static WebElement searchButton;
    @FindBy(css = "span.a-color-state.a-text-bold")
    static WebElement searchResult;
    @FindBy(css = "ul.a-pagination > li:nth-of-type(3) > a")
    static WebElement secondPageButton;
    @FindBy(css = "div.sg-col.s-breadcrumb > div.sg-col-inner > div.a-section > span:nth-of-type(1)")
    static WebElement resultCount;
    @FindBy(id = "atfResults")
    static List<WebElement> searchResultList;
    @FindBy(xpath = ".//*[starts-with(@data-cel-widget, 'search_result_')]")
    static List<WebElement> selectThirdItem;

    public SearchPage(WebDriver wd) {

        PageFactory.initElements(wd, this);
    }

    public boolean checkResults(String expectedInput) {

        return searchResult.getText().equals(expectedInput);
    }

    public boolean checkSecondPageResults() {

        return resultCount.getText().contains("17-32");
    }

    public void setSearchKeyword(String keyword) {

        searchBar.sendKeys(keyword);

    }

    public void clickSearchButton() {

        searchButton.click();

    }

    public void goToSecondPage() {

        secondPageButton.click();

    }

    public String selectThirdItem() {

        String storedThirdItemText = selectThirdItem.get(3)
                .findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).getText();
        selectThirdItem.get(3).findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"))
                .click();

        return storedThirdItemText;
    }
}