package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Links1 
{
	@Test
	public void link() 
	{
	
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	
	for(int i=0;i<=links.size();i++)
	{
		System.out.println(links.get(i).getText());
	}
	
	
	}
}
