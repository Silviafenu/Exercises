package it.corsoAccenture.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.corsoAccenture.Interfaces.BraniDAO;
import it.corsoAccenture.Utilities.DBConnection;

public class BraniDAOImpl implements BraniDAO {
	private static Scanner scan = new Scanner(System.in);
	
	DBConnection db = new DBConnection(); 
	Connection c = db.getConnection();
	
	
	/**
     * Metodo per aggiungere un nuovo brano al database.
     * L'utente inserisce i dati richiesti: ID, nome, titolo del brano e ID dell'album.
     * @param b oggetto Brano 
     * @author Silvia
     */
	@Override
	public void addBrani(Brani b) {
		System.out.println("Inserisci l'ID del brano: ");
		int IDbrano = scan.nextInt(); 
		scan.nextLine();
		System.out.println("Inserisci il nome del autore: ");
		String nomeAutore = scan.nextLine(); 
		System.out.println("Inserisci il titolo: ");
		String titolo = scan.nextLine(); 
		System.out.println("Inserisci l'ID dell'album: ");
		int IDalbum = scan.nextInt(); 
		scan.nextLine();
			
		
		//query
		String sql = "INSERT INTO Brani(id_brano, nomeAutore, titolo, id_genere)" + "VALUES(?,?,?,?)"; 
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, IDbrano); 
			ps.setString(2, nomeAutore);
			ps.setString(3, titolo); 
			ps.setInt(4, IDalbum);
			
			ps.executeUpdate();

			System.out.println("Brano inserito");
			
			ps.close(); 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	
	}
	
	 /**
     * Metodo per leggere tutti i brani dal database.
     * Recupera i dati dalla tabella Brani e li stampa a schermo.
     * @return una lista di oggetti Brano O NULL 
	 */

	@Override
	public List<Brani> readBrani() {
		
		String sql2 = "SELECT * FROM Brani";
		
		try {
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(sql2); 
			
			List<Brani> listaBrani = new ArrayList<Brani>(); 
			
			//fino a che c'è qualcosa 
			while(rs.next()) {
				Brani brano = new Brani(rs.getInt("id_brano"), rs.getString("nomeAutore"), rs.getString("titolo")); 
				listaBrani.add(brano); 
			}
			
			for(Brani brani: listaBrani) {
				System.out.println(brani);
			}
			
			st.close();
			rs.close();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


    /**
     * Metodo per aggiornare il titolo o l'ID di un brano nel database.
     * L'utente specifica l'ID del brano da aggiornare e il nuovo titolo. 
	 */
	@Override
	public void updateBrani() {
		 try {
			  System.out.println("Inserisci l'ID del brano da modificare: ");
		      int idModifica = scan.nextInt();
		      scan.nextLine();
		      
		      System.out.println("Inserisci il nuovo titolo del brano:");
		      String nuovoTitolo = scan.nextLine();
		      
		      String queryAggiornaDati = "UPDATE Brani SET titolo = ? WHERE id_brano = ?";
		      
				PreparedStatement ps = c.prepareStatement(queryAggiornaDati);
				 ps.setString(1, nuovoTitolo);
				 ps.setInt(2, idModifica);
				 
			    System.out.println("Brano aggiornato");

				 
				 ps.executeUpdate(); 


			  }
			 catch(Exception e) {
				  e.printStackTrace();
			  }
	}

	
	  /**
     * Metodo per cancellare un brano dal database.
     * L'utente specifica l'ID del brano da eliminare 
	 */
	@Override
	public void deleteBrani() {
		try {
			System.out.println("Qual'è l'id del brano che vuoi cancellare)");
			int idCancella = scan.nextInt();
			scan.nextLine(); 
			
		    String queryEliminaDati = "DELETE FROM Brani WHERE id_brano = ?";
		    
			PreparedStatement ps = c.prepareStatement(queryEliminaDati);
			 ps.setInt(1, idCancella);
			 
			 System.out.println("Brano cancellato");
			 
			 ps.close();			
		}
		catch(Exception e) {
			  e.printStackTrace();
		  }

	}

}


