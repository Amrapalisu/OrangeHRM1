package com.orangehrm.locators;

public interface Locator {
String username="//input[@name=\"username\"]";
String password="//input[@type=\"password\"]";
String submitbtn="//button[@type=\"submit\"]";
String pimmenu = "//a[contains(@href,\"viewPim\")]";
String addemp = "//a[text()=\"Add Employee\"]";
String fname = "//input[@placeholder=\"First Name\"]";
String mname ="//input[@placeholder=\"Middle Name\"]";
String lname="//input[@placeholder=\\\"Last Name\\\"]";
String subbtn = "//button[@type=\"submit\"]";
Object perdetail = "//h6[normalize-space()='Personal Details']";
}
