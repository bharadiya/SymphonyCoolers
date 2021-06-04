package com.Utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {
	final String path_ = "./Configuration/config.Properties";
     FileInputStream file ;
     Properties ps ;
     
     public PropertyConfig () {
    	 try {
			file = new FileInputStream(path_);
			ps = new Properties();
			ps.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
     }
	 public String getProperty(String key) {	 
		return ps.getProperty(key);
	 }
	
}
