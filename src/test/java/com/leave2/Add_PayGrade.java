package com.leave2;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Add_PayGrade {
	RemoteWebDriver driver = null;

	FluentWait<WebDriver> Wait = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class);
	}

	@Test
	public void verifyAdd_PayGrade() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Job ']")));
		driver.findElement(By.xpath("//span[text()='Job ']")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Pay Grades']")));
		driver.findElement(By.xpath("//a[text()='Pay Grades']")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")));
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"))).sendKeys("Grade41");
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")));
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		//Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"oxd-select-text-input\"]")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]")).click();
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]")));
		driver.findElement(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]")).click();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"))).sendKeys("8000");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"))).sendKeys("10000");
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type=\"submit\"])[2]")));
		driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")).getText();
		String Expected="(1) Record Found";
		 Assert.assertEquals(Actual, Expected);
	}

}
