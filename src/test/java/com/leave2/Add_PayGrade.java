package com.leave2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Keyword;
import com.orangehrm.testbase.TestBase;

public class Add_PayGrade extends TestBase {

	@Test
	public void verifyAdd_PayGrade() throws InterruptedException {
		Keyword keyword = new Keyword();
		Keyword.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]"))).sendKeys("Admin");
		keyword.driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		Keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
		Keyword.driver.findElement(By.xpath("//span[text()='Admin']")).click();
		keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Job ']")));
		Keyword.driver.findElement(By.xpath("//span[text()='Job ']")).click();
		keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Pay Grades']")));
		Keyword.driver.findElement(By.xpath("//a[text()='Pay Grades']")).click();
		keyword.Wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")));
		Keyword.driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"))
				.click();
		keyword.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"))).sendKeys("Grade48");
		keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		keyword.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")));
		keyword.driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		// Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"oxd-select-text-input\"]")));
		Thread.sleep(4000);
		keyword.driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]")).click();
		Keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]")));
		keyword.driver.findElement(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]")).click();
		Keyword.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"))).sendKeys("8000");
		Keyword.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"))).sendKeys("10000");
		Keyword.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type=\"submit\"])[2]")));
		keyword.driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		Thread.sleep(5000);
		String Actual = Keyword.driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")).getText();
		String Expected = "(1) Record Found";
		Assert.assertEquals(Actual, Expected);
	}
  @Test
	public void payGrade_Using_Keyword() throws InterruptedException {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(By.xpath("//input[@name=\"username\"]"));
		keyword.enterText("//input[@name=\"username\"]", "Admin");
		keyword.enterText("//input[@name=\"password\"]", "admin123");
		keyword.click("//button[@type=\"submit\"]");
		keyword.waitForElementToBeVisible(By.xpath("//span[text()='Admin']"));
		keyword.click("//span[text()='Admin']");
		keyword.waitForElementToBeVisible(By.xpath("//span[text()='Job ']"));
		keyword.click("//span[text()='Job ']");
		keyword.waitForElementToBeVisible(By.xpath("//a[text()='Pay Grades']"));
		keyword.click("//a[text()='Pay Grades']");
		keyword.waitForElementToBeVisible(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));
		keyword.click("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
		keyword.waitForElementToBeVisible(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
		keyword.enterText("(//input[@class=\"oxd-input oxd-input--active\"])[2]", "Grade46");
		keyword.waitForElementToBeVisible(By.xpath("//button[@type=\"submit\"]"));
		keyword.click("//button[@type=\"submit\"]");
		keyword.waitForElementToBeVisible(By.xpath("//button[text()=' Add ']"));
		keyword.click("//button[text()=' Add ']");
		Thread.sleep(4000);
		keyword.click("//div[@class=\"oxd-select-text-input\"]");
		keyword.waitForElementToBeVisible(By.xpath("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]"));
		keyword.click("//div[@role='listbox']/descendant::*[contains(text(),'INR - Indian Rupee')]");
		keyword.waitForElementToBeVisible(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"));
		keyword.enterText("(//input[@class=\"oxd-input oxd-input--active\"])[3]", "8000");
		keyword.waitForElementToBeVisible(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"));
		keyword.enterText("(//input[@class=\"oxd-input oxd-input--active\"])[3]", "10000");
		keyword.waitForElementToBeVisible(By.xpath("(//button[@type=\"submit\"])[2]"));
		keyword.click("(//button[@type=\"submit\"])[2]");
		Thread.sleep(5000);
		String Actual = keyword.getText("//span[@class=\"oxd-text oxd-text--span\"]", keyword);
		String Expected = "(1) Record Found";
		Assert.assertEquals(Actual, Expected);

	}

}
