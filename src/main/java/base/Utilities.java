package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utilities {
	
	public String readAProperty(String propertyName) throws Exception {
		Properties prop = new Properties();

		File file = new File(".\\src\\main\\resources\\DevelopmentFiles\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		return prop.getProperty(propertyName);
	}
	
	public String readAProperty(String propertyFilePath, String propertyName) throws Exception {
		Properties prop = new Properties();

		File file = new File(propertyFilePath);
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		return prop.getProperty(propertyName);
	}

}
