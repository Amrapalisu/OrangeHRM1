package com.orangehrm.locators;

public interface Locator {
String username="//input[@name=\"username\"]";
String password="//input[@type=\"password\"]";
String submitbtn="//button[@type=\"submit\"]";
String pimmenu = "//a[contains(@href,\"viewPim\")]";
String addemp = "//a[text()=\"Add Employee\"]";
String fname = "//input[@placeholder=\"First Name\"]";
String mname ="//input[@placeholder=\"Middle Name\"]";
String lname="//input[@placeholder=\"Last Name\"]";
String subbtn = "//button[@type=\"submit\"]";
Object perdetail = "//h6[normalize-space()='Personal Details']";
String adminmod = "//a[contains(@href,'AdminMod')]";
String job = "(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]";
String jobtitle = "//a[text()='Job Titles']";
String addb = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]";
String addt = "(//input[@class=\"oxd-input oxd-input--active\"])[2]";
String subtn = "//button[@type=\"submit\"]";
String JobTitlesh = "//h6[text()='Job Titles']";

String Job = "//h6[text()='Job Titles']";


}
