package com.orangehrm.testbase;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.Keyword;
import com.orangehrm.util.App;

public class TestBase {
	

	@BeforeMethod
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("Chrome");
        keyword.launchurl(App.getAppUrl("qa"));		
	}

	@AfterMethod
	public void tearDown() throws Exception{
		// logOut();
		// Thread.sleep(3000);
		Keyword.driver.quit();

	}
}
