package com.vitger.creatrnewproduct;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.genericutility.Baseclass;
import com.vtiger.objectrepository.Createnewproduct;
import com.vtiger.objectrepository.Home;
import com.vtiger.objectrepository.Product;

@Listeners(com.vtiger.genericutility.ItestListenerIMP.class)
public class Createproduct extends Baseclass
{	
	@Test(retryAnalyzer=com.vtiger.genericutility.Retryanalyzer.class)
	public void createproduct() throws Throwable
	{
		//lg.getLoginbtn().click();
		
		Home hm=new Home(driver);
		web.waitAndClick(hm.getProdtlink());
		hm.getProdtlink().click();
		
		Product p=new Product(driver);
		web.waitAndClick(p.getCreateprod());
		p.getCreateprod().click();
		
		Createnewproduct cp=new Createnewproduct(driver);
		cp.getProdtname().sendKeys("acer1");
		cp.getSavebtn().click();
		
		web.moveToExpectedElemnet(driver, hm.getAdminimg());
		hm.getAdminimg().click();
		hm.getSignout().click();		
	}

}
