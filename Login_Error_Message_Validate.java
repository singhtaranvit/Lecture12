package com.Lecture12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Error_Message_Validate {
	WebDriver driver;
	public SoftAssert sA = new SoftAssert();

	@BeforeTest
	public void openUrl() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}

	@Test(priority = 1)
	public void clickLogin() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]")).getText();
		String expectedMessage = "Register Account";
		sA.assertTrue(actualMessage.contains(expectedMessage));
		sA.assertAll();
	}

	@Test(priority = 2)
	public void clickOnContinue() { // method to validate error messages
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]")).getText();
		String expectedMessage = "Register Account";
		sA.assertTrue(actualMessage.contains(expectedMessage));

		// WebElement Continue
		String actualContinueClickWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedContinueClickWarningMessage = "Warning: You must agree to the Privacy Policy!";
		sA.assertTrue(actualContinueClickWarningMessage.contains(expectedContinueClickWarningMessage));

		// WebElement FirstName
		String actualFirstNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		String expectedFirstNameWarningMessage = "First Name must be between 1 and 32 characters!";
		sA.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));

		// WebElement LastName
		String actualLastNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		String expectedLastNameWarningMessage = "Last Name must be between 1 and 32 characters!";
		sA.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));

		// WebElement Email
		String actualEmailWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		String expectedEmailWarningMessage = "E-Mail Address does not appear to be valid!";
		sA.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));

		// WebElement Telephone
		String actualTelephoneWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		String expectedTelephoneWarningMessage = "Telephone must be between 3 and 32 characters!";
		sA.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));

		// Password
		String actualPasswordWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();
		String expectedPasswordWarningMessage = "Password must be between 4 and 20 characters!";
		sA.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));
		sA.assertAll();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
