package it.corsoAccenture.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.corsoAccenture.Interfaces.GenereDAO;
import it.corsoAccenture.Utilities.DBConnection;

public class GenereDAOImpl implements GenereDAO {
	private static Scanner scan = new Scanner(System.in);
	
	DBConnection db = new DBConnection(); 
	Connection c = db.getConnection();
	
	
	/**
     * Metodo per aggiungere un nuovo Genere al database.
     * L'utente inserisce i dati richiesti: ID, nome del genere.
     * @param b oggetto Brano 
     * @author Silvia
     */
	@Override
	public void addGenere(Genere g) {
		System.out.println("Inserisci l'ID del genere: ");
		int IDgenere = scan.nextInt(); 
		scan.nextLine();
		System.out.println("Inserisci il nome del genere: ");
		String nomeGenere = scan.nextLine(); 
		
		
		//query
		String sql = "INSERT INTO Genere(id_genere, nomeGenere)" + "VALUES(?,?)"; 
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, IDgenere); 
			ps.setString(2, nomeGenere);
			
			ps.executeUpdate();

			System.out.println("Brano inserito");
			
			ps.close(); 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	
}

	 /**
     * Metodo per leggere tutti i generi dal database.
     * Recupera i dati dalla tabella Genere e li stampa a schermo.
     * @return una lista di oggetti Genere O NULL 
	 */


	@Override
	public List<Genere> readGenere() {
		String sql2 = "SELECT * FROM Genere";
		
		try {
			Statement st = c.createStatement();
			
			ResultSet rs = st.executeQuery(sql2); 
			
			List<Genere> listaGenere = new ArrayList<Genere>(); 
			
			//fino a che c'è qualcosa 
			while(rs.next()) {
				Genere brano = new Genere(rs.getInt("id_genere"), rs.getString("nomeGenere")); 
				listaGenere.add(brano); 
			}
			
			for(Genere generi : listaGenere) {
				System.out.println(generi);
			}
			
			st.close();
			rs.close();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
}

	 /**
     * Metodo per aggiornare l'ID e il nome del genere nel database.
     * L'utente specifica l'ID e il nome del genere da aggiornare . 
	 */

	@Override
	public void updateGenere() {
		 try {
			  System.out.println("Inserisci l'ID del genere da modificare: ");
		      int idModifica = scan.nextInt();
		      scan.nextLine();
		      
		      System.out.println("Inserisci il nome del genere:");
		      String nuovoNome = scan.nextLine();
		      
		      String queryAggiornaDati = "UPDATE Genere SET titolo = ? WHERE id_genere = ?";
		      
				PreparedStatement ps = c.prepareStatement(queryAggiornaDati);
				 ps.setString(1, nuovoNome);
				 ps.setInt(2, idModifica);
				 
			    System.out.println("Brano aggiornato");

				 
				 ps.executeUpdate(); 


			  }
			 catch(Exception e) {
				  e.printStackTrace();
			  }
}
	
	 /**
     * Metodo per cancellare un genere dal database.
     * L'utente specifica l'ID del genere da eliminare 
	 */
	@Override
	public void deleteGenere() {
		try {
			System.out.println("Qual'è l'id del genere che vuoi cancellare)");
			int idCancella = scan.nextInt();
			scan.nextLine(); 
			
		    String queryEliminaDati = "DELETE FROM Genere WHERE id_genere = ?";
		    
			PreparedStatement ps = c.prepareStatement(queryEliminaDati);
			 ps.setInt(1, idCancella);
			 
			 System.out.println("Genere cancellato");
			 
			 ps.close();			
		}
		catch(Exception e) {
			  e.printStackTrace();
		  }

	}
}

