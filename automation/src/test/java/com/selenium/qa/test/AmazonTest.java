package com.selenium.qa.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.qa.pages.ItemPage;
import com.selenium.qa.pages.LoginPage;
import com.selenium.qa.pages.SearchPage;
import com.selenium.qa.pages.WishListPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class AmazonTest {

	private WebDriver driver;

	@Test
	public void testSearchAndWishList() {

		// Check the Amazon Page is displayed
		assertTrue(this.driver.getTitle().contains("Amazon.com"));

		LoginPage loginPage = new LoginPage(driver);
		SearchPage searchPage = new SearchPage(driver);
		ItemPage itemPage = new ItemPage(driver);
		WishListPage wishListPage = new WishListPage(driver);

		// Enter the credentials
		loginPage.clickSignInNavBar();
		loginPage.setEmail("testautomationqa1234@gmail.com");
		loginPage.clickContinueButton();
		loginPage.setPassword("123456987");
		loginPage.clickSignInButton();
		
		// Check the Login Successful
		assertTrue(loginPage.checkSuccessLogin());
		
		// Search Page
		searchPage.setSearchKeyword("samsung");
		searchPage.clickSearchButton();
		assertTrue(searchPage.checkResults("\"samsung\""));
		searchPage.goToSecondPage();
		assertTrue(searchPage.checkSecondPageResults());
		String selectedItem = searchPage.selectThirdItem();
		
		// Item is sent to the List
		itemPage.clickAddToListButton();
		itemPage.clickContinueShoppingButton();
		itemPage.clickWishListButton();
		assertTrue(wishListPage.checkWishListHeader());
		assertTrue(wishListPage.checkItemOnWishList(selectedItem));
		
		// Delete the item from the List
		wishListPage.deleteItemOnWishList();
		assertFalse(wishListPage.checkItemOnWishList(selectedItem));

	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
	}

	@AfterMethod

	public void afterMethod() {

		driver.quit();

	}
}