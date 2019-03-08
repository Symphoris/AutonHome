package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import connectionPool.DataSource;
import controller.Controller;
import model.Model;
//import view.AppView;

public class Main {
	

	public static void main(String[] args) {
		
				Model model = new Model();
				System.out.println(DataSource.poolSize());
				System.out.println(DataSource.poolUsedSize());
				System.out.println(model.insert("acteur","nom,date_naissance,specialite,taille,poids","'Marc','1978-02-02','malin',120,110"));
				System.out.println(model.delete("acteur","nom","'Anna'"));
				System.out.println(model.update("acteur","nom","'Tom'","nom='Bob'"));
				ResultSet rs = model.select("acteur","*");
				//System.out.println(rs);
				try {
					while (rs.next()) {
						String txt=rs.getString("nom");
						System.out.println(txt);
					}
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    	try{
		    		model.closeConnection();
		    	}
		    	catch(Exception e) {
		    	}
		    	System.out.println(DataSource.poolSize());
				System.out.println(DataSource.poolUsedSize());
				
				Controller c = new Controller();
				
			
		

	}

}
