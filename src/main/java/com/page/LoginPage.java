package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.DashboardPage;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordField;

	@FindBy(xpath = "//button[@id='kt_login_signin_submit']")
	public WebElement loginButton;

	
	
	public void enterUserName(String username) {
		emailField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public DashboardPage ClickLoginButton() {
		loginButton.click();
		return new DashboardPage(driver);
	}

}
