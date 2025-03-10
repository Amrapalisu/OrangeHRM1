package com.adminpage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.Keyword;
import com.orangehrm.locators.Locator;
import com.orangehrm.testbase.TestBase;

public class AddjobPage extends TestBase{

	@Test
	public void varifyAddEmployeeJob() throws InterruptedException {
		Keyword keyword = new Keyword();

		keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		Keyword.driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");

		Keyword.driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		Keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,'AdminMod')]"));

		Keyword.driver.findElement(By.xpath("//a[contains(@href,'AdminMod')]")).click();
		keyword.waitForElementToBeVisible(By.xpath("(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]"));

		Keyword.driver.findElement(By.xpath("(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]")).click();

		Keyword.driver.findElement(By.xpath("//a[text()='Job Titles']")).click();
		keyword.waitForElementToBeVisible(
				By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));

		Keyword.driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"))
				.click();
		keyword.waitForElementToBeVisible(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));

		Keyword.driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"))
				.sendKeys(" Senior Software Tester");
		Keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Job
		// Titles']")));
		Thread.sleep(6000);
		String actual = Keyword.driver.findElement(By.xpath("//h6[text()='Job Titles']")).getText();

		Assert.assertEquals(actual, "Job Titles");

	}

	@Test
	public void varifyAddEmployeeJobUsingKeyword() throws InterruptedException{
		Keyword keyword = new Keyword();
		//keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"username\"]"));
		Thread.sleep(6000);
		keyword.enterText(Locator.username, "Admin");
		keyword.enterText(Locator.password, "admin123");
		keyword.click(Locator.submitbtn);
		//keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,'AdminMod')]"));
		Thread.sleep(6000);
		keyword.click(Locator.adminmod);
		//keyword.waitForElementToBeVisible(By.xpath("(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]"));
		Thread.sleep(6000);
        keyword.click(Locator.job);
        keyword.click(Locator.jobtitle);
        //keyword.waitForElementToBeVisible(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));
				Thread.sleep(6000);
        keyword.click(Locator.addb);
		//keyword.waitForElementToBeVisible(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        Thread.sleep(6000);
        keyword.enterText(Locator.addt,"Senior Tester" );
        keyword.click(Locator.subtn);
		Thread.sleep(6000);
	String actual=	keyword.getText(Locator.JobTitlesh, keyword);
		Assert.assertEquals(actual, "Job Titles");


	}

}