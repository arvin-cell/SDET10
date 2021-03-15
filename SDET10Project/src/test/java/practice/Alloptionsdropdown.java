package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alloptionsdropdown 
{
	@Test
	public void alldata() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		//driver.findElement(By.id("month")).click();
		Thread.sleep(2000);
		List<WebElement> alldata = driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(alldata.size());
		
		for(int i=0;i<alldata.size();i++)
		{
			System.out.println(alldata.get(i).getText());
		}
	}
}
