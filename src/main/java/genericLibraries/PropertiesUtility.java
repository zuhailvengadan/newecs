package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	private Properties property;
	
	public void propertiesInit(String filepath)
	{
		FileInputStream fis=null;
		try
		{
		fis=new FileInputStream(filepath);

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		property=new Properties();
		try
		{
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public String readData(String key)
		{
			return property.getProperty(key);
		}
	
	public void writeToProperties(String key,String value,String filepath)
	{
		property.put(key, value);
		FileOutputStream fos=null;
		try
		{
			fos=new FileOutputStream(filepath);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			property.store(fos, "Updated");
		}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	}
	
}
