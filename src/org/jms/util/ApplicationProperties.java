package org.jms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
	
	private Properties prop = new Properties();
	private InputStream inputStream = null;
	private final String propertiesName = "jms.properties";
	
	public String getProperty(String key){
		inputStream = getClass().getClassLoader().getResourceAsStream(propertiesName);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
