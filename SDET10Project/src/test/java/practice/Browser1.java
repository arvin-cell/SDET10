package practice;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser1 
{
	@Test
	public void testdata() throws Throwable
	{
		System.setProperty("webdriver.gecko.driver", "./browserexe/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");
		FileInputStream fis=new FileInputStream("./property.properties");
		Properties p=new Properties();
		p.load(fis);
		String un = p.getProperty("username");
		
		driver.findElement(By.id("email")).sendKeys(un);
		driver.close();
		
		
		
	}

}
