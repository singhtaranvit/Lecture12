package com.Lecture12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Soft {
	public WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void openUrl() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@Test(priority = 1)
	public void clickOnMyAccount() {
		driver.findElement(By.linkText("My Account")).click();
	}

	@Test(priority = 2)
	public void openLogin() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		WebElement validate = driver.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
		softAssert.assertTrue(validate.isDisplayed());
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.xpath("input-password"));
		softAssert.assertTrue(email.isEnabled() && password.isEnabled());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void enterValidEmailandPassword() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.xpath("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualMessage = driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).getText();
		String expectedMessage = "Edit your account information";
		softAssert.assertTrue(actualMessage.contains(expectedMessage));
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void enterValidEmailandPasswordAndLogout() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.xpath("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualMessage = driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]"))
				.getText();
		String expectedMessage = "Edit your account information";
		softAssert.assertTrue(actualMessage.contains(expectedMessage));
		driver.findElement(By.linkText("Logout")).click();
		String actualLogoutMessage = driver.findElement(By.xpath(
				"//a[contains(text(),'You have been logged off your account.It id now safe to leave your computer')]"))
				.getText();
		String expectedLogoutMessage = "You have been logged off your account.It id now safe to leave your computer";
		softAssert.assertTrue(actualLogoutMessage.contains(expectedLogoutMessage));
		softAssert.assertAll();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
