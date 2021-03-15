package practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Duplicatedropdown 
{
	@Test
	public void findduplicate() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(2000);
		WebElement list = driver.findElement(By.id("month"));
		
		Select s=new Select(list);
		List<WebElement> list1 = s.getOptions();
		for(WebElement w:list1)
		{
			System.out.println(w.getText());
		}
		
		Set<String> listnames=new HashSet<String>(list1.size());
		for(WebElement w:list1)
		{
			listnames.add(w.getText().trim());
		}
		if(list1.size()==listnames.size())
		System.out.println("list contains no duplicates");	
		else
		System.out.println("list contains duplicate");
		
		

		
		
	}
}
