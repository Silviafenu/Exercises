package it.corsoAccenture.View;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.corsoAccenture.Entities.Libro;
import it.corsoAccenture.Entities.Utente;
import it.corsoAccenture.Utilities.DBConnection;

public class Menu {
	private static Scanner scan = new Scanner(System.in);

	public void startMenu(){
		DBConnection db1 = new DBConnection(); 
		Connection c = db1.getConnection(); 
		
		int scelta; 
		
		do {
			System.out.println("Scelte: "
					+ "\n[1] -► Inserimento nuovo utente "
					+ "\n[2] -► Inserimento nuovo libro "
					+ "\n[3] -► Richiesta di prestito "
					+ "\n[4] -► Stampare le query create nell'esercizio precedente  "
			        + "\n[5] -► Modifica dati di un libro");
			
			 scelta = scan.nextInt(); 
			}
			while(scelta != 5); 
			
		switch(scelta) {
			case 1 :
				//1 inserimento nuovo utente e stampa ID 
				
				System.out.println("Inserisci l'ID utente: ");
				int IDutente = scan.nextInt(); 
				scan.nextLine();
				System.out.println("Inserisci il nome: ");
				String nome = scan.nextLine(); 
				System.out.println("Inserisci il cognome: ");
				String cognome = scan.nextLine(); 
				System.out.println("Inserisci l'eta: ");
				int eta = scan.nextInt(); 
				 scan.nextLine();
				
				//query
				String sql = "INSERT INTO utenti(id_utente, nome, cognome, eta)" + "VALUES(?,?,?,?)"; 
				try {
					PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, IDutente); 
					ps.setString(2, nome);
					ps.setString(3, cognome); 
					ps.setInt(4, eta); 
					
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					
					if(rs.next()) {
						IDutente = rs.getInt(1); 
						System.out.println("\n id utente: " + IDutente);
					}
					
					System.out.println("Utente inserito");
					
					ps.close(); 
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
				
				break;
			
		  case 2: 
			// 2 inserimento Libro e stampa ID 
				
				System.out.println("Inserisci l'ID Libro: ");
				int IDLibro = scan.nextInt(); 
				scan.nextLine();
				System.out.println("Inserisci il titolo: ");
				String titolo = scan.nextLine(); 
				System.out.println("Inserisci l'autore: ");
				String autore = scan.nextLine(); 

				
//				//query
				String sql2 = "INSERT INTO Libri(id_libro, titolo, autore)" + "VALUES(?,?,?)"; 
				try {
					PreparedStatement ps = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, IDLibro); 
					ps.setString(2, titolo);
					ps.setString(3, autore); 
					
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					
					if(rs.next()) {
						IDLibro = rs.getInt(1); 
						System.out.println("\n id Libro: " + IDLibro);
					}
					
					System.out.println("Libro inserito");
					
					ps.close(); 
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
				
				break; 
			
		  case 3: 
//				// 3 Richiesta di prestito richiedendo id_utente, id_libro, numero_di_giorni
			    
				System.out.println("\n Inserisci l'ID utente per il prestito: ");
				int IDUtente2 = scan.nextInt(); 
				scan.nextLine();
				System.out.println("\n Inserisci l'ID Libro per il prestito: ");
				int IDLibro2 = scan.nextInt(); 
				scan.nextLine(); 
				LocalDate dataInizioPrestito = LocalDate.now();
				System.out.println("\n Data di inizio prestito: " + dataInizioPrestito);
				System.out.println("\n Inserisci il numero di giorni: ");
				int giorniPrestito = scan.nextInt(); 
				LocalDate dataFineRestituzione = dataInizioPrestito.plusDays(giorniPrestito);
				System.out.println("\n Data di fine prestito: " + dataFineRestituzione);

				
				//query che resituisce un dato 
				String sql3 = "INSERT INTO prestito(dataInizio, dataFine, id_utente, id_libro)"+ "VALUES(?,?,?,?)" ;
				
				try {
					PreparedStatement ps = c.prepareStatement(sql3);
					ps.setDate(1, Date.valueOf(dataInizioPrestito)); 
					ps.setDate(2, Date.valueOf(dataFineRestituzione));
					ps.setInt(3, IDUtente2); 
					ps.setInt(4, IDLibro2);
					
					
					System.out.println("Prestito andato a buon fine");

					ps.close(); 
					
				}
				catch (SQLException e) {
					e.printStackTrace();
				} 
				
				break; 
			
		  case 4: 
			  int sceltaQuery; 
			  
			  do {
					System.out.println("Scelte: "
							+ "\n[1] -► Cercare tutti i libri prestati ad un utente specifico in ordine cronologico "
							+ "\n[2] -► Vedere i primi tre lettori che hanno letto più libri "
							+ "\n[3] -► Vedere tutti i possessori dei libri non ancora rientrati e il titolo degli stessi. "
							+ "\n[4] -► Storico dei libri chiesti in prestito da un utente indicando il periodo di riferimento."
					        + "\n[5] -► Classifica dei libri maggiormente prestati."
			                + "\n[6] -► Vederr tutti i prestiti la cui durata supera i 15gg");

					sceltaQuery = scan.nextInt(); 
					}
				while(sceltaQuery != 6);
		
		switch(sceltaQuery) {
		  case 1: 
			//1. Cercare tutti i libri prestati ad un utente specifico
				String qr1 = "SELECT l.titolo, l.autore FROM prestito p JOIN libri l ON (p.id_libro = l.id_libro) WHERE p.id_utente = 1001 ORDER BY p.dataInizio";
				
				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr1); 
					
					List<Libro> libriprestati = new ArrayList<Libro>(); 
					
					while(rs.next()) {
						Libro lib1 = new Libro(rs.getString("titolo"), rs.getString("autore")); 
						libriprestati.add(lib1); 
					}
					
					for(Libro libri: libriprestati) {
						System.out.println(libri);
					}
				
					st.close();
					rs.close();
				
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				
				break;
			
		  case 2: 
			//2. Individua i primi tre lettori che hanno letto più libri
				String qr2 = "SELECT u.nome, u.cognome, count(*) libriLetti FROM prestito p JOIN utenti u ON (p.id_utente = u.id_utente)GROUP BY u.id_utente ORDER BY libriLetti DESC LIMIT 3";
				
				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr2); 
					
					
					while(rs.next()) {
					    System.out.println("nome: "+ rs.getString(1)); 
					    System.out.println("congome: "+ rs.getString(2));
					    System.out.println("libri letti: "+ rs.getInt(3));
					    System.out.println();
					}
					
						
					st.close();
					rs.close();
				
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				
				break; 
			
		  case 3: 
			//3. Individua tutti i possessori dei libri non ancora rientrati e il titolo degli stessi.
				String qr3 = "SELECT u.nome, u.cognome, l.titolo FROM utenti u JOIN prestito p ON (u.id_utente = p.id_utente) JOIN libri l ON (p.id_libro = l.id_libro) WHERE p.dataFine IS NULL";
				
				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr3); 
					
					
					while(rs.next()) {
					    System.out.println("nome: "+ rs.getString(1)); 
					    System.out.println("congome: "+ rs.getString(2));
					    System.out.println("titolo: "+ rs.getString(3));
					    System.out.println();
					}
					
					st.close();
					rs.close();
				
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				
				break;
			
		  case 4: 
			// 4 . Dare lo storico dei libri chiesti in prestito da un utente indicando il periodo di riferimento. 
				String qr4 = "SELECT  l.titolo FROM prestito p JOIN libri l ON (p.id_libro = l.id_libro) WHERE p.id_utente = 1003 AND p.dataInizio BETWEEN \"2024-03-15\" AND \"2024-03-30\"";
				
				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr4); 
					
					
					while(rs.next()) {
					    System.out.println("titolo: "+ rs.getString(1));
					    System.out.println();
					}
					
					st.close();
					rs.close();
				
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				
				break;
				
		  case 5: 
			//5 Fai la classifica dei libri maggiormente prestati.
				String qr5 = "SELECT l.titolo, count(*) libriPrestati FROM utenti u JOIN prestito p ON (u.id_utente = p.id_utente) JOIN libri l ON (p.id_libro = l.id_libro) GROUP BY l.id_libro ORDER BY libriPrestati DESC";

				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr5); 
					
					
					while(rs.next()) {
					    System.out.println("titolo: "+ rs.getString(1));
					    System.out.println("libro prestato: "+ rs.getInt(2));
					    System.out.println();
					}
					
					st.close();
					rs.close();
				
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				break;
				
		  case 6: 
			  String qr6 = "SELECT l.titolo, p.dataInizio FROM prestito p JOIN libri l ON (p.id_libro = l.id_libro) WHERE datediff(p.dataFine, p.dataInizio) > 15";

				try {
					Statement st = c.createStatement();
					
					ResultSet rs = st.executeQuery(qr6); 
					
					
					while(rs.next()) {
					    System.out.println("titolo: "+ rs.getString(1));
					    System.out.println("data prestito: "+ rs.getDate(2));
					    System.out.println();
					}
					
					st.close();
					rs.close();
				
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
				
				break;
				
				default: 
					System.out.println("Finite le query!");
			
	    	}  
		
	     	 break; 
	     	 
		  case 5: 
			 try {
			  System.out.println("Inserisci l'ID del libro da modificare: ");
		      int idModifica = scan.nextInt();
		      scan.nextLine();
		      
		      System.out.println("Inserisci il nuovo titolo del libro:");
		      String nuovoTitolo = scan.nextLine();
		      
		      String queryAggiornaDati = "UPDATE Libri SET titolo = ? WHERE id_libro = ?";
		      
				PreparedStatement ps = c.prepareStatement(queryAggiornaDati);
				 ps.setString(1, nuovoTitolo);
				 ps.setInt(2, idModifica);
				 
			    System.out.println("Libro aggiornato");

				 
				 ps.executeUpdate(); 


			  }
			 catch(Exception e) {
				  e.printStackTrace();
			  }
		      			  
				
	}

}
}
