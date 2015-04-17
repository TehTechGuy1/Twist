package com.alan.gfg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	
	Properties properties = new Properties();

	public void saveConfig(String key, int value){
		String path = "res/settings/config.xml";
		try{
			File file = new File(path);
			boolean exists = file.exists();
			if(!exists){
				file.createNewFile();
			}
			OutputStream write = new FileOutputStream(path);
			properties.setProperty(key, Integer.toString(value));
			properties.storeToXML(write, "Resolution");
		}catch(Exception e){
		}
	}
	
	public void loadConfig(String path){
		try{
			InputStream read = new FileInputStream(path);
			properties.loadFromXML(read);
			String width = properties.getProperty("width");
			String height = properties.getProperty("height");
			setRes(Integer.parseInt(width), Integer.parseInt(height));
			read.close();
		}catch(FileNotFoundException e){
			saveConfig("width", 1024);
			saveConfig("height", 576);
			loadConfig(path);
		}catch(IOException e){
			
		}
	}
	public void setRes(int width, int height){
		Game.w = width;
		Game.h = height;
	}
}
