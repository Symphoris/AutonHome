package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import controller.Controller;
import model.Model;
//import view.AppView;

public class Main {
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				/*Model model = new Model();
				System.out.println(model.insert("acteur","nom,date_naissance,specialite,taille,poids","'SEI','1978-02-02','malin',120,110"));
				System.out.println(model.delete("acteur","nom","'Tom'"));
				System.out.println(model.update("acteur","nom","'Tom'","nom='SEI'"));
				ResultSet rs = model.select("acteur","*");
				System.out.println(rs);
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
		    	}*/
				
				Controller c = new Controller();
				
				
			}
		});
		

	}

}
