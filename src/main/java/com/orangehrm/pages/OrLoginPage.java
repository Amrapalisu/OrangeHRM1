package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.IFactoryAnnotation;

import com.orangehrm.Keyword;
import com.orangehrm.util.App;

public class OrLoginPage {
	@FindBy(css = "input[name=\"username\"]")
	WebElement usernameTxtBx;

	@FindBy(css = "input[type=password]")
	WebElement passwordTxtBx;

	@FindBy(css = "button[type=submit]")
	WebElement loginbtn;
	public OrLoginPage() {
		PageFactory.initElements(Keyword.driver, this);
		
	}

	public void enterUsername(String username) {
		usernameTxtBx.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTxtBx.sendKeys(password);
	}

	public void clickonLoginbtn() {
		loginbtn.click();
	}
	public void waitforUsernameToBeVisible() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(usernameTxtBx);
	}

}
