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

import com.orangehrm.Keyword;
import com.orangehrm.locators.Locator;
import static com.orangehrm.util.Locators.*;

import com.orangehrm.util.App;
import com.orangehrm.util.PropertiesUtil;

public class AddEmp {
	@Test
	public void verifyThatTheEmployeeIsSuccessfullyAddedByCheckingTheEmpListForPersonalDetails() {
		Keyword keyword = new Keyword();

		keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");

		// driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		keyword.waitForElementToBeVisible(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
		keyword.waitForElementToBeVisible(By.xpath("//button[@type=\"submit\"]"));
		Keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// String pagetitle = driver.getTitle();
		// Assert.assertEquals("OrangeHRM", pagetitle);
		System.out.println("Login Successful");

		keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,\"viewPim\")]"));

		Keyword.driver.findElement(By.xpath("//a[contains(@href,\"viewPim\")]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//a[text()=\"Add Employee\"]"));

		Keyword.driver.findElement(By.xpath("//a[text()=\"Add Employee\"]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//input[@placeholder=\\\"First Name\\\"]"));

		Keyword.driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Amrap");
		Keyword.driver.findElement(By.xpath("//input[@placeholder=\"Middle Name\"]")).sendKeys("M");
		Keyword.driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Sonta");
		keyword.waitForElementToBeVisible(By.xpath("//button[@type=\"submit\"]"));

		Keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		keyword.waitForElementToBeVisible(By.xpath("//h6[normalize-space()='Personal Details']"));

		String conformmsg = Keyword.driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"))
				.getText();
		/*
		 * if(actr.contains("Personal Details")) {
		 * System.out.println("Employee added successfully"); } else {
		 * System.out.println("No record found"); }
		 */
		Assert.assertEquals("Personal Details", conformmsg);

	}

	@Test
	public void verifyThatTheEmployeeIsSuccessfullyAddedByCheckingTheEmpListForPersonalDetailsUsingKeywords() {
		Keyword keyword = new Keyword();

		keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"username\"]"));
		keyword.enterText(Locator.username, App.getuserName("qa"));
		keyword.enterText(Locator.password, App.getPassword("qa"));
		keyword.click("xpath", Locator.submitbtn);
		
		keyword.waitForElementToBeVisible(By.xpath("//a[contains(@href,\"viewPim\")]"));
		keyword.click("xpath", Locator.pimmenu);
		keyword.waitForElementToBeVisible(By.xpath("//a[text()=\"Add Employee\"]"));
		keyword.click("xpath", Locator.addemp);
		keyword.waitForElementToBeVisible(By.xpath("//input[@placeholder=\"First Name\"]"));
		keyword.enterText("css",Locator.fname, "Amrap");
		keyword.enterText("css", Locator.mname, "M");
		keyword.enterText("css", Locator.lname, "Sonta");
		keyword.waitForElementToBeVisible(By.xpath("//button[@type=\"submit\"]"));
		keyword.click("xpath", Locator.subbtn);
		keyword.waitForElementToBeVisible(By.xpath("//h6[normalize-space()='Personal Details']"));
		String conformmsg = keyword.getText("xpath", Locator.perdetail);
		Assert.assertEquals("Personal Details", conformmsg);
	}
}