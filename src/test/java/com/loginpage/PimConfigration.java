package com.loginpage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimConfigration {
	RemoteWebDriver driver = null;
	FluentWait<WebDriver> Wait = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(800)));
		Wait.ignoring(NoSuchElementException.class);
	}

	@Test
	public void verifyDataImportAddSuccessfully() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,\"viewPim\")]"))).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Configuration \"]"))).click();

		driver.findElement(By.xpath("//a[text()='Reporting Methods']")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"))).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")));

		driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys(" madi");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"submit\"]")));

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-main-title\"]")));

		String Actual=driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-main-title\"]")).getText();
		String Expect="Add Reporting Method";
		Assert.assertEquals(Actual, Expect);
     
	}

}
