package com.vitger.creatrnewproduct;

import org.testng.annotations.Test;

import com.vtiger.genericutility.Baseclass;
import com.vtiger.objectrepository.Createnewproduct;
import com.vtiger.objectrepository.Home;
import com.vtiger.objectrepository.Login;
import com.vtiger.objectrepository.Product;

public class Createproductmandtoryfield extends Baseclass

{
	@Test
	public void createProductMandtoryfield() throws Throwable
	{
		
		Home hm=new Home(driver);
		web.waitAndClick(hm.getProdtlink());
		hm.getProdtlink().click();
		
		Product p=new Product(driver);
		web.waitAndClick(p.getCreateprod());
		p.getCreateprod().click();
		
		Createnewproduct cp=new Createnewproduct(driver);
		cp.getSavebtn().click();
		web.alerttOK(driver);
		
		web.moveToExpectedElemnet(driver, hm.getAdminimg());
		hm.getAdminimg().click();
		hm.getSignout().click();
		
	}

}


