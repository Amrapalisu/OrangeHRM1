package com.orangehrm;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.orangehrm.errors.InvalidBrowserError;


public class Keyword {
	public static RemoteWebDriver driver = null;
	public static FluentWait<WebDriver> Wait = null;

	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Launch chrome Browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Launch Firefox Browser");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			System.out.println("Launch Safari Browser");
		} else {
			throw new InvalidBrowserError(browserName);

		}
		driver.manage().window().maximize();

		Wait = new FluentWait<WebDriver>(Keyword.driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class, org.openqa.selenium.NoSuchSessionException.class);
	}

	public void launchurl(String url) {
		driver.get(url);
	}

	public void enterText(String locator, String textToEnter) {
		driver.findElement(By.xpath(locator)).sendKeys(textToEnter);

	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath("locatorValue")).sendKeys("textToEnter");

		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("className")) {
			driver.findElement(By.className("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			driver.findElement(By.linkText("locatorValue")).sendKeys("textToEnter");
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			driver.findElement(By.partialLinkText("locatorValue")).sendKeys("textToEnter");
		} else {
			throw new InvalidSelectorException(locatorType);
		}

	}

	/**
	 * use this method to click on {@code webElement} by its xpath. this method
	 * doesn't support other locator strategies
	 * 
	 * @param by
	 * @return
	 */
	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	/**
	 * this method can be used to click on element, you need to provide locator type
	 * and locator-value
	 * 
	 * @param locatorType that is one of following:
	 *                    id,name,css,tagname,classname,linktext,etc
	 * 
	 */
	public void click(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("clasname")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			driver.findElement(By.linkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			driver.findElement(By.partialLinkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();

		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}

	public String getText(String locator, Object perdetail) {
		return driver.findElement(By.xpath(locator)).getText();
	}

	public WebElement waitForElementToBeVisible(By by) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by);
	}
}
