package com.selenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {

	@FindBy(id = "add-to-wishlist-button-submit")
	static WebElement addToListButton;
	@FindBy(css = "#nav-link-accountList > span:nth-of-type(2)")
	static WebElement accountListNavBar;
	@FindBy(css = "div.nav-panel > a:nth-of-type(1) > span.nav-text")
	static WebElement wishListButton;
	@FindBy(id = "WLHUC_continue")
	static WebElement continueShoppingButton;

	private WebDriver driver;

	public ItemPage(WebDriver wd) {
		this.driver = wd;

		PageFactory.initElements(wd, this);
	}

	public void clickAddToListButton() {

		addToListButton.click();

	}

	public void clickContinueShoppingButton() {

		continueShoppingButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(accountListNavBar));
	}

	public void clickWishListButton() {
		Actions action = new Actions(driver);
		action.moveToElement(accountListNavBar).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(wishListButton));
		
		
		action.moveToElement(accountListNavBar).moveToElement(wishListButton).click().build().perform();
	}

}
