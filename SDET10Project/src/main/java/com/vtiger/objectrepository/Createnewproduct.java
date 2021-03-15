package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewproduct 
{

	public Createnewproduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement prodtname;
	
	@FindBy(name="button")
	private WebElement savebtn;

	public WebElement getProdtname() {
		return prodtname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

}
