package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.page.LoginPage;
import com.utility.ExcelUtils;
import com.utility.ExtentManager;

public class LoginTest extends Base {

	private ExtentReports extent;
	private ExtentTest test;
	private LoginPage loginPage;

	@BeforeSuite
	public void setUpExtent() {
		extent = ExtentManager.createInstance();
	}

	@BeforeMethod
	public void setUp() {
		super.setUp(); 
		loginPage = new LoginPage(driver);
	}

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {
		return ExcelUtils.getTestData("LoginData");
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String email, String password) throws InterruptedException {
		test = extent.createTest("Login Test for " + email);
		loginPage.enterUserName(email);
		loginPage.enterPassword(password);
		Thread.sleep(10000);
		loginPage.ClickLoginButton();
		Assert.assertTrue(true);
		
	}

	@AfterMethod
	public void tearDown() {
			 driver.quit();
		}
	

	@AfterSuite
	public void tearDownExtent() {
		extent.flush();
	}
}
