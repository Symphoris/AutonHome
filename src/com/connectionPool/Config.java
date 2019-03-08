package com.connectionPool;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
	private static Config config = new Config();
	private static  String  Driver;
	private static  String url ;
	private static  String user ;
	private static  String password ;
	private static int nb_init;
	private static int nb_max;
	
	//constructeur private car conception singleton
	
	private Config() {
		Properties p = new Properties();
		InputStream file = null;
        try {
			
			file = new FileInputStream("config.properties");

			// charger le fichier properties
			p.load(file);
			
			// recuperer les fichiers properties
			Driver  = p.getProperty("Driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password  = p.getProperty("password");
			 nb_init = Integer.parseInt(p.getProperty("nb_init"));
			 nb_max= Integer.parseInt(p.getProperty("nb_max"));
			
		} 
        catch (IOException ex) {
        	//System.out.println("erreur file");
        }
        
		finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					
				}
			}
		}
		
        
	}
	
	public static String getDriver() {
		return Driver;
	}
	
	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}
	
	public static int getNb_init() {
		return nb_init;
	}

	public static int getNb_max() {
		return nb_max;
	}
	public static Config getConfig() {
		if(config==null) {
			config=new Config();
		}
		return config;
	}
	
	

}
