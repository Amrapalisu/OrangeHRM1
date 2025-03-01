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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	RemoteWebDriver driver = null;
	FluentWait<WebDriver> Wait = new FluentWait<WebDriver>(driver);

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // for maximise the window
		driver.get("https://opensource-demo.orangehrmlive.com/");

		Wait = new FluentWait<WebDriver>(driver);
		Wait.withTimeout(Duration.ofSeconds(60));
		Wait.pollingEvery((Duration.ofMillis(500)));
		Wait.ignoring(NoSuchElementException.class, org.openqa.selenium.NoSuchSessionException.class);
	}

	@Test(priority = 2)
	public void verifyUserEnterTheInvalidCredential() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Aadmin");

		// driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"password\"]")));
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin1234");
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String expectedmsg = "Invalid credentials";
		Thread.sleep(3000);
		String Actualmsg = driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]"))
				.getText();
		System.out.println("Invalid credentials");

		Assert.assertEquals(expectedmsg, Actualmsg);

	}

	@Test(priority = 1)
	public void verifyUserEnterTheValidCredential() {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");

		// driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"password\"]")));
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String pagetitle = driver.getTitle();
		SoftAssert softly = new SoftAssert();
		Assert.assertEquals("OrangeHRM", pagetitle);
		System.out.println("Login Successful");
	}

	@Test(priority = 3, enabled = false)
	public void verifyThatTheEmployeeIsSuccessfullyAddedByCheckingTheEmpListForPersonalDetails()
			throws InterruptedException {

		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");

		// driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
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

		driver.findElement(By.xpath("//a[text()=\"Add Employee\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Amrap");
		driver.findElement(By.xpath("//input[@placeholder=\"Middle Name\"]")).sendKeys("M");
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Sonta");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(5000);
		String conformmsg = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();
		/*
		 * if(actr.contains("Personal Details")) {
		 * System.out.println("Employee added successfully"); } else {
		 * System.out.println("No record found"); }
		 */
		Assert.assertEquals("Personal Details", conformmsg);

	}

	@Test(priority = 4, enabled = false) //How to ignore the test case- using @ignore annotation, enabled=false, using include= and exclude 
	public void verifyTheEmployeeByName() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")))
				.sendKeys("Admin");

		// driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
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
		System.out.println("Record is : ");
		String expectedmsg = "(3) Records Found";
		String actualmsg = element.get(0).getText();
		SoftAssert softly = new SoftAssert();
		for (int i = 0; i < element.size(); i++) {
			String ele = element.get(i).getText();
			softly.assertEquals(ele, "Record Found");
		}
		softly.assertAll();
		}

	

	/*
	 * public void logOut() throws InterruptedException { //
	 * Wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//p[@class=\"oxd-userdropdown-name\"]"))); Thread.sleep(3000);
	 * driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click()
	 * ; Thread.sleep(3000);
	 * driver.findElement(By.xpath("//a[text()='Logout']")).click();
	 * 
	 * /* for (int i = 0; i < elelist.size(); i++) { System.out.println(i + " " +
	 * elelist.get(i).getText()); }
	 * 
	 * elelist.get(3).click(); }
	 */
	// }*/

	@AfterMethod
	public void tearDown() throws Exception {
		// logOut();
		// Thread.sleep(3000);
		driver.quit();

	}

}
