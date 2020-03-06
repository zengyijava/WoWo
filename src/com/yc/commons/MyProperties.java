package com.yc.commons;

import java.io.IOException;
import java.util.Properties;

//ʹ�õ���ģʽ���������ļ�

public class MyProperties extends Properties{
	private static MyProperties properties=null;
	
	private MyProperties()
	{
		try {
			load(MyProperties.class.getClassLoader().getResourceAsStream("db.properties"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static MyProperties getInstance()
	{
		if(null==properties)
		{
			properties=new MyProperties();
		}
		return properties;
		
	}

}
