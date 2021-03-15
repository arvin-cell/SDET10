
package com.vitger.testcaseforproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericutility.Fileutility;
import com.vtiger.genericutility.Webdriverutility;

public class Combinesmokeandregression1
{

	Fileutility pfile=new Fileutility();
	Webdriverutility wb=new Webdriverutility();
	
	@Test(groups ="smoke")
	public void createtestcaseproduct1() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(pfile.getpropertyfile("url"));			
		driver.findElement(By.name("user_name")).sendKeys(pfile.getpropertyfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(pfile.getpropertyfile("password"));
		driver.findElement(By.id("submitButton")).click();		
		// click on product
		wb.waitForPageToLoad(driver);
		driver.findElement(By.linkText("Products")).click();		
		//navigate to create page + icon
		wb.waitForPageToLoad(driver);		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		wb.waitForPageToLoad(driver);
		driver.findElement(By.name("productname")).sendKeys("hi");
		driver.findElement(By.name("button")).click();		
		//logout
		wb.moveToExpectedElemnet(driver, driver.findElement(By.xpath("(//td[@class='small'])[2]")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		driver.close();
	}
	@Test(groups = "regression")
	public void createproductwitactiveandverify() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
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
		// creating product
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Dell");
		driver.findElement(By.name("button")).click();		
		String actualresult=driver.findElement(By.xpath("//span[@id='dtlview_Product Active']")).getText();
		String expected="yes";		
		Assert.assertTrue(actualresult.contains(expected));
	}

}
