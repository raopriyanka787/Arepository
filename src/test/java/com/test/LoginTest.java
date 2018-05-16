package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raop\\chromedriver_win32 (2)\\chromedriver.exe");
		log.info("Launching Chrome");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Maximized Chrome");
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		log.info("Launching Application URL");
		driver.get("http://www.freecrm.com/");
	}

	@Test(priority = 1)
	public void freeCRMLogoTest() {
		WebElement ele = driver.findElement(By.xpath("//img[@class='img-responsive']"));
		Boolean boo = ele.isDisplayed();
		Assert.assertTrue(boo);

	}

	@Test(priority = 2)
	public void freeCRMTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser closed");
	}

}
