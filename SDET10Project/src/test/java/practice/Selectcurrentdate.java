package practice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selectcurrentdate 
{
	@Test
	public void selectcurrentdate()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();;
		// click calender window and unable the popup
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		Date d=new Date();
		String strdate = d.toString();
		String[] arr=strdate.split(" ");
		
		String year=arr[5];
		String month=arr[1];
		String date=arr[2];
		String day=arr[0];
		
		
		String x="//div[contains(@aria-label,'"+day+" "+month+" "+date+" "+year+"')]/div/p[text()='"+date+"']";
		System.out.println(x);
		driver.findElement(By.xpath(x)).click();
		
		
		
		
		
		
		
		
		
		
		
				
		
	}
}
