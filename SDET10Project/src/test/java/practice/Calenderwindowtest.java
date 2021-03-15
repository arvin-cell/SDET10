package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Calenderwindowtest 
{
	@Test
	
	public void calender() 
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		//click on calender window
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		int count=0;
		while(count<11)
		try 
		{
		String x="//div[@aria-label='Tue Jul 20 2021']/div/p[text()='20']";
		driver.findElement(By.xpath(x)).click();;
		System.out.println("given date is valid");
		break;
		}
		
		catch(Exception e)
		{
			// click on next month until we get date
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			count++;
		}
		if(count==11)
		{
			System.out.println("date is invalid");
		}
	}
	

}
