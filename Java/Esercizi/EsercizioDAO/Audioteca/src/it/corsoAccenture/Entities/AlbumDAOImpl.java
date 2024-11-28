package it.corsoAccenture.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.corsoAccenture.Interfaces.AlbumDAO;
import it.corsoAccenture.Utilities.DBConnection;

public class AlbumDAOImpl implements AlbumDAO {
	private static Scanner scan = new Scanner(System.in);
	
	DBConnection db = new DBConnection(); 
	Connection c = db.getConnection();
	
	/**
     * Metodo per aggiungere un nuovo album al database.
     * L'utente inserisce i dati richiesti: ID, nome, titolo e genere dell'album.
     * @param a oggetto Album 
     * @author Silvia
     */
	@Override
	public void addAlbum(Album a) {
		System.out.println("Inserisci l'ID dell'album: ");
		int IDalbum = scan.nextInt(); 
		scan.nextLine();
		System.out.println("Inserisci il nome dell'album: ");
		String nomeAlbum = scan.nextLine(); 
		System.out.println("Inserisci il titolo: ");
		String titolo = scan.nextLine(); 
		System.out.println("Inserisci il genere dell'album: ");
		
		List<String> listaGenere = new ArrayList<String>();
		listaGenere.add("1 -> Rock");
		listaGenere.add("2 -> Jazz");
		listaGenere.add("3 -> Pop");
		listaGenere.add("4 -> Folk");
		listaGenere.add("5 -> Reggie");
				
		for(String generi : listaGenere) {
			System.out.println(generi);
		}
		int genere = scan.nextInt(); 
		
		if(listaGenere.contains(genere)) {
			//query
			String sql = "INSERT INTO Album(id_album, nomeAlbum, titolo, id_genere)" + "VALUES(?,?,?,?)"; 
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, IDalbum); 
				ps.setString(2, nomeAlbum);
				ps.setString(3, titolo); 
				ps.setInt(4, genere); 
				
				ps.executeUpdate();

				System.out.println("Album inserito");
				
				ps.close(); 
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
		
		}else {
			System.out.println("Scegli un genere corretto");
		}
	}

		
	
	 /**
     * Metodo per leggere tutti gli album dal database.
     * Recupera i dati dalla tabella Album e li stampa a schermo.
     * @return una lista di oggetti Album O NULL 
	 */

	@Override
	public List<Album> readAlbum() {
		String sql2 = "SELECT * FROM Album";
		
		
		try {
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(sql2); 
			
			List<Album> listaAlbum = new ArrayList<Album>(); 
			
			//fino a che c'è qualcosa 
			while(rs.next()) {
				Album album = new Album(rs.getInt("id_album"), rs.getString("nomeAlbum"), rs.getString("titolo")); 
				listaAlbum.add(album); 
			}
			
			for(Album utente: listaAlbum) {
				System.out.println(utente);
			}
			
			st.close();
			rs.close();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
    /**
     * Metodo per aggiornare il titolo di un album nel database.
     * L'utente specifica l'ID dell'album da aggiornare e il nuovo titolo. 
	 */

	@Override
	public void updateAlbum() {
		 try {
			  System.out.println("Inserisci l'ID del Album da modificare: ");
		      int idModifica = scan.nextInt();
		      scan.nextLine();
		      
		      System.out.println("Inserisci il nuovo titolo del Album:");
		      String nuovoTitolo = scan.nextLine();
		      
		      String queryAggiornaDati = "UPDATE Album SET titolo = ? WHERE id_album = ?";
		      
				PreparedStatement ps = c.prepareStatement(queryAggiornaDati);
				 ps.setString(1, nuovoTitolo);
				 ps.setInt(2, idModifica);
				 
			    System.out.println("Album aggiornato");

				 
				 ps.executeUpdate(); 


			  }
			 catch(Exception e) {
				  e.printStackTrace();
			  }
	}
	
	  /**
     * Metodo per cancellare un album dal database.
     * L'utente specifica l'ID dell'album da eliminare 
	 */

	@Override
	public void deleteAlbum() {
		try {
			System.out.println("Qual'è l'id dell'album che vuoi cancellare)");
			int idCancella = scan.nextInt();
			scan.nextLine(); 
			
		    String queryEliminaDati = "DELETE FROM Album WHERE id_album = ?";
		    
			PreparedStatement ps = c.prepareStatement(queryEliminaDati);
			 ps.setInt(1, idCancella);
			 
			 System.out.println("Album cancellato");
			 
			 ps.close();			
		}
		catch(Exception e) {
			  e.printStackTrace();
		  }

	}

}
