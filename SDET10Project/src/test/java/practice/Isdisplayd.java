package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Isdisplayd 
{
	@Test
	public void isdisplayedornot()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");

		boolean titlename = driver.findElement(By.tagName("title")).isDisplayed();
		System.out.println(titlename);
	}
}
