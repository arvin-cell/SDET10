package com.vtiger.genericutility;

import java.util.Date;
import java.util.Random;



public class Javautility 
{
	Date dateobj=new Date();
	public int random()
	{
		Random r=new Random();
		int num = r.nextInt(100);
		return num;
		
	}
	public String getcurrentsystemdate()
	{
		Date date=new Date();
		String currentdate=date.toString();
		return currentdate;
		
	}
}
