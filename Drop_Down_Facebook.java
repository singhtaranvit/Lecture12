package com.Lecture12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Drop_Down_Facebook {
	WebDriver driver;
	public SoftAssert sA = new SoftAssert();

	@BeforeTest
	public void openFacebookCreateAccount() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
	}

	@Test(priority = 1)
	public void clickCreateNewAccount() throws InterruptedException {
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Gary");
		driver.findElement(By.name("lastname")).sendKeys("Singh");
		driver.findElement(By.name("reg_email__")).sendKeys("singht2110@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("123456789");

		// for selecting month
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Jan");
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("10");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1995");
		driver.findElement(By.cssSelector("span._5k_2:nth-child(2) > label:nth-child(1)")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
