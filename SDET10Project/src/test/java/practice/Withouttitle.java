package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Withouttitle 
{
	@Test(invocationCount = 5)
	public void title()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		//String title = driver.getTitle();
		//System.out.println(title);
		WebElement titlename = driver.findElement(By.tagName("title"));
		System.out.println("Title of the page is:"+titlename.getAttribute("titlecontent"));
	}

}
