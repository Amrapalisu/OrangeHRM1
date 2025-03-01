package com.loginpage;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EmpSearch {

	RemoteWebDriver driver = null;
	FluentWait<WebDriver> Wait = new FluentWait<WebDriver>(driver);

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // for maximise the window
		driver.get("https://opensource-demo.orangehrmlive.com/");

		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class);

	}

	@Test
	public void verifyTheEmployeeByName() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");

//driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"password\"]")));
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// String pagetitle = driver.getTitle();
		// Assert.assertEquals("OrangeHRM", pagetitle);
		System.out.println("Login Successful");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,\"viewPim\")]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"Employee List\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]")).sendKeys("Amrap");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(5000);
		List<WebElement> element = driver.findElements(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]"));
		// System.out.println("Record is : ");
		// String expectedmsg="(3) Records Found";
		// String actualmsg=element.get(0).getText();
		// Assert.assertEquals(expectedmsg,actualmsg);

		SoftAssert softly = new SoftAssert();
		for (int i = 0; i < element.size(); i++) {
			String actualmsg = element.get(i).getText();
			softly.assertEquals(actualmsg, "Record Found");
		}
		softly.assertAll();

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
