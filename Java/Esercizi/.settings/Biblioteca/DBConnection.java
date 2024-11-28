package it.corsoAccenture.Biblioteca;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	private Connection conn = null; 
	
	private String connString;
	private String host;
	private String portaDB;
	private String nomeDB;
	private String userDB;
	private String passwDB;
	private String optionDB; 
	
	//per poter recuperare i dati dal file, si utilizza una classe 
	private ResourceBundle rb; 
	
	public Connection getConnection() {
		rb = ResourceBundle.getBundle("application");
		this.connString = rb.getString("connectionstring"); 
		this.host = rb.getString("host");
		this.portaDB = rb.getString("port");
		this.nomeDB = rb.getString("db");
		this.userDB = rb.getString("user");
		this.passwDB = rb.getString("psw");
		this.optionDB = rb.getString("opt"); 
		
		//se nulla la creo, altrimenti la ritorno 
		if(conn == null) {
			//#jdbc:mysql://host:port/nomeDB?serverTimezone=Europe/Rome
			this.connString += this.host + ":" +this.portaDB + "/"+ this.nomeDB +this.optionDB; 
			
			//richiamo il drivermanager
			try {
				
				conn = DriverManager.getConnection(this.connString, this.userDB, this.passwDB);
				
			} catch (SQLException e) {
				System.out.println("non sono riuscito a collegarmi al db");
				System.out.println(e.getMessage());
				
				e.printStackTrace();
				
			} 
		}
		
		
		return conn; 
	}

}