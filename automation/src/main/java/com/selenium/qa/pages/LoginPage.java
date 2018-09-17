package com.selenium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "ap_email")
	static WebElement username;
	@FindBy(id = "continue")
	static WebElement continueButton;
	@FindBy(id = "ap_password")
	static WebElement password;
	@FindBy(id = "signInSubmit")
	static WebElement signInButton;
	@FindBy(id = "nav-link-accountList")
	static WebElement signInNavBar;
	@FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div/a[2]/span[1]")
	static WebElement signInText;

	public LoginPage(WebDriver wd) {

		PageFactory.initElements(wd, this);
	}

	public boolean checkSuccessLogin() {

		return signInText.getText().equals("Hello, test");
	}

	public void setEmail(String name) {

		username.sendKeys(name);

	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);

	}

	public void clickContinueButton() {

		continueButton.click();

	}

	public void clickSignInButton() {

		signInButton.click();

	}

	public void clickSignInNavBar() {

		signInNavBar.click();

	}

}
