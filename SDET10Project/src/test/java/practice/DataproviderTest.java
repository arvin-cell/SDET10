package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest 
{	
	int count=0;
	@Test(dataProvider="getdata")
	public void bookingtest(String src, String dest) throws Throwable
	{

		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");

		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		

		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();

		act.moveByOffset(14, 14).click().perform();
		
		driver.findElement(By.xpath("//div[text()='Search']")).click();
		List<WebElement> listflight = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		int cnt = listflight.size();
		System.out.println("Number of flights:"+cnt);
	
		String noflight = String.valueOf(cnt);
		Excelutility eu=new Excelutility();
		eu.setExcelData("sheet1", count, 2, noflight);
		count++;
		
		
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		Excelutility excel=new Excelutility();
		int rowindex = excel.getRowCount("sheet1");
		rowindex++;
		
		Object[][] objarr=new Object[rowindex][2];
		for(int i=0;i<rowindex;i++)
		{
			objarr[i][0]=excel.getexceldata("sheet1", i, 0);
			objarr[i][1]=excel.getexceldata("sheet1", i, 1);
		}
		return objarr;
		
		
	}
	
	
}
