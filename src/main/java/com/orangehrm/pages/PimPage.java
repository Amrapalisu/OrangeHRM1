package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.Keyword;

public class PimPage {
	@FindBy(css = "a.oxd-topbar-body-nav-tab-item:nth-child(1)")
	WebElement Addemployee;
	@FindBy(css = "input[name='firstName']")

	WebElement FristName;
	
	@FindBy(css = "input[name=\"middleName\"]")
	WebElement MiddleName;
	
	@FindBy(css = "input[name=\"lastName\"]")
	WebElement LastName;
	
	@FindBy(css = "button[type=\"submit\"]")
	WebElement SubmitB;
	

	public PimPage() {
		PageFactory.initElements(Keyword.driver, this);

	}

	public void clickonAddemployee() {
		Addemployee.click();
	}

	public void Fristname(String Fristname) {
		FristName.sendKeys(Fristname);
	}

	public void middlename(String Middlename) {
		MiddleName.sendKeys(Middlename);
	}

	public void lastname(String Lastname) {
		LastName.sendKeys(Lastname);
	}
	

	public void waitForAddEmployeeToBevisibile() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(Addemployee);
	}

}
