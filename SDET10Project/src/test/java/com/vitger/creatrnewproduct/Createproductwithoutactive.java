package com.vitger.creatrnewproduct;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericutility.Baseclass;
import com.vtiger.objectrepository.Createnewproduct;
import com.vtiger.objectrepository.Home;
import com.vtiger.objectrepository.Login;
import com.vtiger.objectrepository.Product;

public class Createproductwithoutactive extends Baseclass
{
	@Test
	
	public void createProductWithoutActive() throws Throwable
	{
		
		Home hm=new Home(driver);
		web.waitAndClick(hm.getProdtlink());
		hm.getProdtlink().click();
		
		Product p=new Product(driver);
		web.waitAndClick(p.getCreateprod());
		p.getCreateprod().click();		

		Createnewproduct cp=new Createnewproduct(driver);
		cp.getProdtname().sendKeys("acer4");
		p.getChkbox().click();
		cp.getSavebtn().click();
		
		String actualresult = p.getChkproductactive().getText();
		String expected="no ";		
		Assert.assertTrue(actualresult.contains(expected));
		

	}

}
