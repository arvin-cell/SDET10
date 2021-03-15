package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home 
{
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProdtlink() {
		return prodtlink;
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignout() {
		return signout;
	}

	@FindBy(xpath="//a[text()='Products']")
	private WebElement prodtlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	
	
	
}
