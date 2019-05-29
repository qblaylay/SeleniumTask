package com.selenium.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {

    @FindBy(id = "profile-list-name")
    static WebElement wishListHeader;

    @FindBy(name = "submit.deleteItem")
    static WebElement deleteItemButton;

    @FindBy(xpath = ".//*[starts-with(@id, 'item_')]")
    static List<WebElement> wishlist;

    @FindBy(xpath = "/html/body/div[2]/header/div/div[1]/div[4]/div[3]/div[2]/div/div[1]/div[3]/div/a[1]/span")
    static WebElement wishListButton;

    @FindBy(css = "div.a-box.a-alert-inline.a-alert-inline-success > div.a-box-inner.a-alert-container > div.a-alert-content")
    static WebElement deletedText;

    private WebDriver driver;

    public WishListPage(WebDriver wd) {
        this.driver = wd;
        PageFactory.initElements(wd, this);
    }

    public boolean checkWishListHeader() {

        return wishListHeader.getText().equals("Wish List");
    }

    public boolean checkItemOnWishList(String storedItem) {

        return wishlist.get(0).getText().contains(storedItem) && !wishlist.get(0).getText().contains("Deleted");

    }

    public void deleteItemOnWishList() {
        deleteItemButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(deletedText));

    }
}
