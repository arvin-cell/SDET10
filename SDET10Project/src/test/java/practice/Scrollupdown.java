package practice;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.Arguments;

public class Scrollupdown 
{
	@Test
public void scrolldown()
{
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com");

	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	// scroll down visibility of element
	WebElement ele = driver.findElement(By.xpath("//p[text()='Bangalore Flights']"));
	js.executeScript("arguments[0].scrollIntoView()",ele);
	// scroll down
	//js.executeScript("window.scrollBy(0,1250)");
	// scroll up
	//js.executeScript("window.scrollBy(0,-1100)");
	
}
}
