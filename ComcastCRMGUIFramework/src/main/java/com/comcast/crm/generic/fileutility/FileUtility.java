package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromProperties(String key) throws Exception
	{
		
		FileInputStream fis = new FileInputStream("./configAppData/CommonData1.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		return data;
		
	}

	

	

}
