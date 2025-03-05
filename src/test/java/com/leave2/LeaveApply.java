package com.leave2;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveApply {
	RemoteWebDriver driver = null;
	
	FluentWait<WebDriver> Wait = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class);
	}
	@Test
	public void verifyLeaveApplySuccessfully() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,\"viewPim\")]")));
		driver.findElement(By.xpath("//a[contains(@href,\"viewPim\")]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reports']")));
		driver.findElement(By.xpath("//a[text()='Reports']")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Type for hints...\"]")));
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).click();
		List<WebElement> nameList = driver.findElements(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
		boolean isFound = false;
		for (WebElement name : nameList) {
			if (name.getText().contains("Employee Job Details")) {
				isFound = true;
				break;
			}
		//	Assert.assertTrue(isFound);
		}
		//driver.findElement(By.xpath("//hr[@role='separator']/descendant::*[contains(text(),'Employee Job Details')]")).click();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(6000);
		//Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='(1) Record Found']")));
	String s=driver.findElement(By.xpath("//span[text()='(1) Record Found']")).getText();
	String a="(1) Record Found";
	Assert.assertEquals(s, a);
	}
}
