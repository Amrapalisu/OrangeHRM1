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

public class SearchtheUser {

	RemoteWebDriver driver = null;
	FluentWait<WebDriver> Wait = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class);
	}

	@Test
	private void verifySearchTheUser() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'AdminMod')]")));
		driver.findElement(By.xpath("//a[contains(@href,'AdminMod')]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[@class=\"oxd-label\"])[1]")));

		driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("Amrapali");
		driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'ESS')]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Madhuri Mokashe");
		driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'Enabled')]")).click();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actual = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span\"])[1]")).getText();
		String expected = "(16) Records Found";
		Assert.assertEquals(actual,expected);
		
	}
}
