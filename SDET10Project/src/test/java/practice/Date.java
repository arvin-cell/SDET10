package practice;

import java.text.SimpleDateFormat;
import java.util.*;
public class Date 
{
	public static void main(String[] args)
	{
		SimpleDateFormat s=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		Date d=new Date();
		System.out.println(s.format(d));
		
	}

}
