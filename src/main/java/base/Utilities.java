package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utilities {
	
	public String readAProperty(String propertyName) throws Exception {
		Properties prop = new Properties();

		File file = new File(".\\ProjectProperty.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		return prop.getProperty(propertyName);
	}
	
	public String readAProperty(String propertyFileName, String propertyName) throws Exception {
		Properties prop = new Properties();

		File file = new File(propertyFileName);
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		return prop.getProperty(propertyName);
	}

}
