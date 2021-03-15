package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUseredit() {
		return useredit;
	}

	public WebElement getPassedit() {
		return passedit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	@FindBy(name="user_name")
	private WebElement useredit;
	
	@FindBy(name="user_password")
	private WebElement passedit;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public void credentials(String username, String password)
	{
		useredit.sendKeys(username);
		passedit.sendKeys(password);
		loginbtn.click();
	}
	
	

}
