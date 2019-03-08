package controller;

import java.sql.Connection;
import java.util.Scanner;

import connectionPool.Config;
import connectionPool.DataSource;
import model.Model.*;
import model.Model;
//import view.AppView;

public class Controller {
	private Model model;
	Scanner sc = new Scanner(System.in);
	//private AppView view;
	
	public Controller() {
		//Model model = new Model();
		Config.getConfig();
		this.start();
		
	}
	public void start() {
		//System.out.println(Config.getDriver());
		System.out.println(DataSource.poolSize());
		System.out.println(DataSource.poolUsedSize());
		Connection cn2=DataSource.getConnection();
		System.out.println(cn2);
		System.out.println(DataSource.poolSize());
		System.out.println(DataSource.poolUsedSize());
		Connection cn1=DataSource.getConnection();
		System.out.println(DataSource.poolSize());
		System.out.println(DataSource.poolUsedSize());
		DataSource.closeConnections();
		System.out.println(DataSource.poolSize());
		System.out.println(DataSource.poolUsedSize());
	}
		
		/*while(true) {
			System.out.println("Taper :");
			System.out.println("0 pour ajouter un capteur");
			System.out.println("1 pour modifier un capteur");
			System.out.println("2 pour supprimer un capteur");
			System.out.println("3 pour afficher les capteurs");
			System.out.println("4 pour terminer");
			switch(sc.nextInt()) {
			case 0 : this.insert();
			case 1 : this.update();
			case 2 : this.delete();
			case 3 : this.select();
			case 4 : break;
			default : System.out.println("erreur");
			}
		}
	}
		public void insert() {
			String table=sc.nextLine();
			String colonne=sc.nextLine();
			String valeur=sc.nextLine();
			model.insert(table, colonne, valeur);
		}
		
		public void delete() {
			String table=sc.nextLine();
			String label=sc.nextLine();
			String valeur=sc.nextLine();
			model.delete(table, label, valeur);
		}
		
		public void update() {
			String table=sc.nextLine();
			String label=sc.nextLine();
			String valeur=sc.nextLine();
			String condition=sc.nextLine();
			model.update(table, label, valeur,condition);
		}
		
		public void select() {
			String table=sc.nextLine();
			String label=sc.nextLine();
			model.select(table, label);
		}*/
			
}
