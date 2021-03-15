package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderBasic 
{
	@Test(dataProvider="getdata")
	public void sampledata(String src, String dest)
	{
		System.out.println("source :"+ src +"  Destination :"+ dest );
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		Excelutility excel=new Excelutility();
		int rowindex = excel.getRowCount("Sheet1");
		rowindex++;
		Object[][] objarr=new Object[rowindex][2];
		for(int i=0;i<rowindex;i++)
		{
			objarr[i][0]=excel.getexceldata("Sheet1", i, 0);
			objarr[i][1]=excel.getexceldata("Sheet1",i, 1);
		}
		return objarr;	
	}
}
