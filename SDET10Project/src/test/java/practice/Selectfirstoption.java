package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selectfirstoption 
{
	@Test

	public void selectfirstoption() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		//driver.findElement(By.id("month")).click();
		Thread.sleep(2000);
		WebElement alldata = driver.findElement(By.xpath("//select[@id='month']"));
		Select s=new Select(alldata);
		 s.selectByValue("1");
	}
		
	}

