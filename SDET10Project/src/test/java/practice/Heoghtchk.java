package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Heoghtchk
{
	@Test
	public void heighttext()
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement ele = driver.findElement(By.name("q"));
		System.out.println(ele.getRect().getDimension().getHeight());
		System.out.println(ele.getRect().getDimension().getWidth());
	}
}
