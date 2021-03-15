package com.vtiger.genericutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectrepository.Login;

public class Baseclass 
{
	// object creation 	
	public static WebDriver driver;
	public Excelutility excelfile=new Excelutility();
	public Fileutility pfile=new Fileutility();
	public Javautility rdm=new Javautility();
	//public Databaseutility db=new Databaseutility();
	public Webdriverutility web=new Webdriverutility();
	//public WebDriver driver;

	@BeforeSuite
	public void configBeforeSuite() throws Throwable 
	{
		System.out.println("==============Connect to DB=============");
		//db.connectToDB();
	}

	
	@BeforeClass
	public void configBeforeClass() throws Throwable 
	{
		System.out.println("============launch the Browser==========");
		/* launch the Browser*/
		/*read Common Data*/
		String URL = pfile.getpropertyfile("url");

		String BROWSER = pfile.getpropertyfile("browser");
		
		 if(BROWSER.equals("firefox")) 
		 {

			System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equals("chrome")) 
		 {
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		 }
		 else if(BROWSER.equals("ie")) 
		 {
			 driver = new InternetExplorerDriver();
		 }
		 else 
		 {

			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		
		 web.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	@Parameters("Browser")
	//@BeforeClass
	public void configBeforeClassparallel(String browser) throws Throwable 
	{
		System.out.println("============launch the Browser==========");
		/* launch the Browser*/
		/*read Common Data*/
		String URL = pfile.getpropertyfile("url");
		//String BROWSER = pfile.getpropertyfile("browser");
		
		 if(browser.equals("firefox")) 
		 {

			System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
		 }
		 else if(browser.equals("chrome")) 
		 {
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		 }
		 else if(browser.equals("ie")) 
		 {
			 driver = new InternetExplorerDriver();
		 }
		 else 
		 {

			 System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
				driver=new FirefoxDriver();
		 }
		
		 web.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	@BeforeMethod
	public void configBeforeMtd() throws Throwable
	{
		System.out.println("====login to Application=====");
		/*step-1 : login to Application*/
		String username = pfile.getpropertyfile("username");
		String password = pfile.getpropertyfile("password");
		Login lp=new Login(driver);
		lp.credentials(username, password);
	}
	
	@AfterMethod
	public void configAfterMethod() throws Throwable
	{
		System.out.println("====logout from Application=====");
	      /*step-* : logout */    
    }

		
	@AfterClass
	public void configAfterClass()
	{
		System.out.println("============Close the Browser==========");
		driver.close();
	}
	
/*	
	@AfterSuite
	public void configAfterSuite() throws Throwable
	{
		System.out.println("==============close db Connection=============");
		db.closeDb();
	}
	*/
}
