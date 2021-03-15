package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browser 
{
	@Test
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("arvind");
		driver.findElement(By.id("passContainer")).sendKeys("arvind");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.name("q")).sendKeys("Selenium");
		//W ebElement link = driver.findElement(By.tagName("a"));
		//System.out.println(link);
		driver.close();
		
	}

}
