package com.ebanking.utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File ("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	public String getURl() {
		String url =pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String username =pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password =pro.getProperty("password");
		return password;
	}
	public String getChromepath() {
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
}
