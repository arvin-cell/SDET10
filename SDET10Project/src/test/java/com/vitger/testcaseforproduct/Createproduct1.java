package com.vitger.testcaseforproduct;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericutility.Excelutility;
import com.vtiger.genericutility.Fileutility;
import com.vtiger.genericutility.Javautility;
import com.vtiger.genericutility.Webdriverutility;

public class Createproduct1 
{
	Fileutility pfile=new Fileutility();
	Webdriverutility wb=new Webdriverutility();
	Excelutility excel=new Excelutility();
	Javautility jt=new Javautility();
	
	
	@Test
	public void createtestcaseproduct1() throws Throwable 
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
		wb.waitForPageToLoad(driver);
		driver.findElement(By.linkText("Products")).click();
		
		
		//navigate to create page + icon
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//wb.waitForPageToLoad(driver);
		
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		wb.waitForPageToLoad(driver);
		driver.findElement(By.name("productname")).sendKeys(excel.getexceldata("data1",0,0)+ "_"+jt.random());
		driver.findElement(By.name("button")).click();
		
	
		// click pn product and check product is available in product list or not
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys("ibm");
		wb.selectdropdown(driver.findElement(By.id("bas_searchfield")),"Product Name");
		driver.findElement(By.name("submit")).click();
		
		
		String actualresult=driver.findElement(By.xpath("//a[@title='Products']")).getText();
		String expected="ibm";
		Assert.assertEquals(actualresult, expected);
		
		
		//logout
		wb.moveToExpectedElemnet(driver, driver.findElement(By.xpath("(//td[@class='small'])[2]")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
	}

}
