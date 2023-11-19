package com.Lecture12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assertion_Tutorial_Ninja {
	public WebDriver driver;

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
		Assert.assertTrue(validate.isDisplayed());
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.xpath("input-password"));
		Assert.assertTrue(email.isEnabled() && password.isEnabled());
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
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
@Test(priority = 4)
public void enterValidEmailandPasswordAndLogout() {
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
	driver.findElement(By.xpath("input-password")).sendKeys("Selenium@123");
	driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	String actualMessage = driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).getText();
	String expectedMessage = "Edit your account information";
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	driver.findElement(By.linkText("Logout")).click();
	String actualLogoutMessage = driver.findElement(By.xpath("//a[contains(text(),'You have been logged off your account.It id now safe to leave your computer')]")).getText();
	String expectedLogoutMessage = "You have been logged off your account.It id now safe to leave your computer";
	Assert.assertTrue(actualLogoutMessage.contains(expectedLogoutMessage));
}
@AfterTest
public void tearDown()
{
driver.quit();
}
}
