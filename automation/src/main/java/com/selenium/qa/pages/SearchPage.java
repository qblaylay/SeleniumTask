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
	@FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")
	static WebElement searchButton;
	@FindBy(css = "span.a-color-state.a-text-bold")
	static WebElement searchResult;
	@FindBy(css = "#pagn > span:nth-of-type(3) > a")
	static WebElement secondPageButton;
	@FindBy(id = "s-result-count")
	static WebElement resultCount;
	@FindBy(id = "atfResults")
	static List<WebElement> searchResultList;
	@FindBy(xpath = ".//*[starts-with(@id, 'result_')]")
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

		String storedThirdItemText = selectThirdItem.get(2)
				.findElement(By.cssSelector(".a-size-medium.s-inline.s-access-title.a-text-normal")).getText();

		selectThirdItem.get(2).findElement(By.cssSelector(".a-size-medium.s-inline.s-access-title.a-text-normal"))
				.click();

		return storedThirdItemText;
	}

}
