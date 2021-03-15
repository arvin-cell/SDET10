package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Dynamicwebtabel 
{
	@Test
	public void capturedaynamicwebtable() 
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		// click on product
		driver.findElement(By.linkText("Products")).click();
		
		// capture all the product name from 3rd column
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
		List<WebElement> listname = driver.findElements(By.xpath(x));
		
		for(WebElement wb:listname)
		{
			System.out.println(wb.getText());
		}
		
	}	
		
}
