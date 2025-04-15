package com.loginpage;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUser {
	
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
		public void verifyIfNameOfAlreadyCreateduserPopulatesInList() throws InterruptedException {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

			Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
					.sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,\"viewPim\")]")));
			driver.findElement(By.xpath("//a[contains(@href,\"viewPim\")]")).click();
			Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()=' Add ']")));

			driver.findElement(By.xpath("//button[text()=' Add ']")).click();
			Thread.sleep(3000);
			Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name=\"firstName\"]")));
			driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("John");
			driver.findElement(By.xpath("//input[@name=\"middleName\"]")).sendKeys("");
			driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Wick");
			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(@href,'AdminMod')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()=' Add ']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]")).click();
			driver.findElement(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'ESS')]")).click();
			// div[@role='dialog']/descendant::*[contains(text(),'ESS')]
			driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("John");
			Thread.sleep(3000);

			List<WebElement> nameList = driver.findElements(By.xpath("//div[@role='option']/span"));
			boolean isFound = false;
			for (WebElement name : nameList) {
				if (name.getText().contains("John")) {
					isFound = true;
					break;
				}
				Assert.assertTrue(isFound);
			}
		}

		@AfterClass
		public void tearDown() throws Exception {
			driver.quit();
		}

	}


