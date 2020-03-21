package com.qa.zeroapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZeroAppTestCases extends ReusableMethods {

	@BeforeTest
	@Parameters("browser")
	public void Initialize(String browser) {
		InitializeDriver(browser);
		CreateReport();
	}

	@Test
	public void Login_1() throws InterruptedException {
		logger = report.startTest("XeroAppTest");
		// OpenUrl("https://www.xero.com/us/");
		OpenUrl("https://login.xero.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "URL opened successfully");
		WebElement Uname = driver.findElement(By.id("email"));
		EnterText(Uname, "edrsiri@gmail.com", "Username");
//		Thread.sleep(3000);
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "sisha0@xero", "Password");
		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		Click(loginBtn, "Login Button");
	}

//
//	@Test
//	// @Parameters("browser")
//	public void Login_2() throws InterruptedException {
//		logger = report.startTest("XeroAppTest");
//		OpenUrl("https://login.xero.com/");
//
//		// driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		logger.log(LogStatus.INFO, "URL opened successfully");
//		WebElement Uname = driver.findElement(By.id("email"));
//		EnterText(Uname, "edrsiri@gmail.com", "Username");
//
//		WebElement pwd = driver.findElement(By.id("password"));
//		EnterText(pwd, "sisha@xero", "Password");
//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		Click(loginBtn, "Login Button");
//
//	}
//
//	@Test
//	public void Login_3() throws InterruptedException {
//		logger = report.startTest("XeroAppTest");
//		OpenUrl("https://login.xero.com/");
//
//		// driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		logger.log(LogStatus.INFO, "URL opened successfully");
//		WebElement Uname = driver.findElement(By.id("email"));
//		EnterText(Uname, "edrsir@gmail.com", "Username");
//
//		WebElement pwd = driver.findElement(By.id("password"));
//		EnterText(pwd, "sisha0@xero", "Password");
//
//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		Click(loginBtn, "Login Button");
//
//	}
//
	@AfterTest
	public void CloseTest() {
		CloseBrowser();
		CloseReport();
	}

}
