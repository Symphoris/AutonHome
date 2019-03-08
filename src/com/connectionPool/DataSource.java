package com.connectionPool;
import java.sql.Connection;
public class DataSource {
		//attribut
		private static JDBCConnectionPool jdbc = new JDBCConnectionPool();
		
		public DataSource(){
			
		}
	
		//methodes
			
		public static Connection getConnection() {
			return jdbc.getConnection();
		}
		
		public static  void freeConnection(Connection a) {
			jdbc.freeConnection(a);
		}
		
		public static void closeConnections() {
			jdbc.closeConnections();
		}
		 public static int poolSize() {
			 return jdbc.poolSize() ;
		 }
		
	
	

}
