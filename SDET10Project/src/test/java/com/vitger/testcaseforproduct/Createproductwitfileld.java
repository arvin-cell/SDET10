package com.vitger.testcaseforproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericutility.Fileutility;
import com.vtiger.genericutility.Webdriverutility;

public class Createproductwitfileld 
{

	Fileutility pfile=new Fileutility();
	Webdriverutility wb=new Webdriverutility();
	
	@Test
	public void createproductwitfild() throws Throwable
	{
		System.setProperty("webdriver.gecko.driver","./browserexe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		//navigate to app
		//driver.manage().window().maximize();
		driver.get(pfile.getpropertyfile("url"));
		
		
		driver.findElement(By.name("user_name")).sendKeys(pfile.getpropertyfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(pfile.getpropertyfile("password"));
		driver.findElement(By.id("submitButton")).click();
		
		// click on product
		driver.findElement(By.linkText("Products")).click();
		
		//navigate to create page + icon
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		// click on save button
		driver.findElement(By.name("button")).click();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		// logout
		wb.moveToExpectedElemnet(driver, driver.findElement(By.xpath("(//td[@class='small'])[2]")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
		driver.close();
		
		
		
		
		
		
	}

}
