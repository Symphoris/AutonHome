package com.connectionPool;
import java.sql.*;
import java.util.Vector;

public class JDBCConnectionPool {
	private static Vector<Connection> pool;
	private static Vector<Connection> poolUsed;
	
	 private static int nbConnection;
	 private static String url= Config.getUrl();
	 private static String user = Config.getUser();
	 private static String password = Config.getPassword();
	 private static int nb_init = Config.getNb_init();
	private static int nb_max = Config.getNb_max();
	
	
	public JDBCConnectionPool() {
		pool = new Vector<Connection>(nb_init);
		poolUsed = new Vector<Connection>(nb_init);
		try {
			Class.forName(Config.getDriver());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fill();
		
	}
	 
	 
	 
	//methodes
	 
		 public void fill() {
			 for(int k=1;k<=nb_init;k++) {
				try {
					Connection a = DriverManager.getConnection(url,user,password);
					pool.add(a);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 
		 }
		 	
		 
		 public Connection getConnection(){
			 //on verifie si la pool est vide 
			
			
			Connection a11 =null;
			try {
					 
				a11 = pool.remove(0);
				poolUsed.add(a11);
			}
			catch(ArrayIndexOutOfBoundsException e){
					 
				try{
					if(poolUsed.size()<nb_max) {
						a11 = DriverManager.getConnection(url,user,password);
						poolUsed.add(a11);
					}
				} 
				catch (SQLException f) {}
				
			}
			 
			return a11;
		}
				 
		 
		 public void freeConnection(Connection a) {
			 pool.add(a);
			 poolUsed.remove(a);
		 }
		 
		 
		 public void closeConnections() {
			 for(int k=0;k<pool.size();k++) {
				try {
					pool.get(k).close();
				} catch (SQLException e) {}
			 }
			 if(!poolUsed.isEmpty()) {
				 for(int k=0;k<poolUsed.size();k++) {
						try {
							poolUsed.get(k).close();
						} catch (SQLException e) {}
					 }
				 
			 }
			 pool.clear();
			 poolUsed.clear();
		 }
		 public static int poolSize() {
			 return pool.size();
		 }
		 public static int poolUsedSize() {
			 return poolUsed.size();
		 }
	

}
