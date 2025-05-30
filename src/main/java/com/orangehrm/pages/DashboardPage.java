package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.Keyword;

public class DashboardPage {
	@FindBy(css = "a[href*=viewAdmin]")
	WebElement Admin;

	@FindBy(css = "a[href*=Pim]")

	WebElement PimMenu;

	@FindBy(css = "a[href*=leave]")
	WebElement LeaveMenu;

	public DashboardPage() {
		PageFactory.initElements(Keyword.driver, this);// this:current class instance
	}

	public void clickonAdminMenu() {
		Admin.click();

	}

	public void clickonPimMenu() {
		PimMenu.click();

	}

	public void clickonLeaveMenu() {
		LeaveMenu.click();

	}

	public void waitForPimMenuToBevisibile() {
		Keyword keyword = new Keyword();
		keyword.waitForElementToBeVisible(PimMenu);
	}
}
