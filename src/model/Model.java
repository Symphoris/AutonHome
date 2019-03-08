package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionPool.DataSource;


public class Model {
	 private DataSource ds = new DataSource();
	 private Connection cn = null;
	 private Statement st ; 
	 
	 
	 public Model () {
		 cn = ds.getConnection();
		 try {
			st = cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public boolean insert (String table, String colonne, String valeur) {
		try {
			 st.executeUpdate("insert into "+ table +" ("+colonne+") values ("+valeur+")");
			 return true;
		}catch(Exception e) {return false;}
		 
	 }
	 
     public ResultSet select (String table, String label) {
    	 try {
			 ResultSet rs = st.executeQuery("select "+ label +" from "+table);
			 System.out.println(true);
			 return rs;
		}catch(Exception e) {return null;}
    	 
		 
	 }
     
     public boolean delete (String table, String label, String valeur) {
     try {
			 st.executeUpdate("delete from "+ table +" where "+label+"="+valeur);
			 return true;
		}catch(Exception e) {return false;}
		 
	 }
     
     public boolean update (String table, String label, String valeur, String condition) {
         try {
    			 st.executeUpdate("update "+ table +" set "+label+"="+valeur+" where "+condition);
    			 return true;
    		}catch(Exception e) {return false;}
    		 
    	 }
     
     public void closeConnection() {
			try {
				st.close();
				ds.freeConnection(cn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
