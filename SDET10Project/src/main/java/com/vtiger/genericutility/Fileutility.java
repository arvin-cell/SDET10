package com.vtiger.genericutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Arvind
 *
 */

public class Fileutility 
{
	public String getpropertyfile(String key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./property.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value; 
		
	}

}
