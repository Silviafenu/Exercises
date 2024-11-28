package it.corsoAccenture.View;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import it.corsoAccenture.Entities.Album;
import it.corsoAccenture.Entities.AlbumDAOImpl;
import it.corsoAccenture.Entities.Brani;
import it.corsoAccenture.Entities.BraniDAOImpl;
import it.corsoAccenture.Entities.Genere;
import it.corsoAccenture.Entities.GenereDAOImpl;
import it.corsoAccenture.Utilities.DBConnection;

public class Menu {
	private static Scanner scan = new Scanner(System.in);
	private static DBConnection db1 = new DBConnection(); 


	public void startMenu(){
		Connection c = db1.getConnection(); 
		
		Album alb = new Album(1, "Thriller", "Billie Jean"); 
		AlbumDAOImpl alb1 = new AlbumDAOImpl();
		
		Brani brano = new Brani(101, "Freddie Mercury", "Bohemian Rhapsody"); 
		BraniDAOImpl brn1 = new BraniDAOImpl(); 
		
		Genere genere = new Genere(201, "Rock");
		GenereDAOImpl gnr1 = new GenereDAOImpl(); 
		
		int scelta; 
		do {
			System.out.println("Scegli in quale oggetto vuoi effettuare operazioni: "
					+ "\n[1] -► Album"
					+ "\n[2] -► Brani"
					+ "\n[3] -► Genere"
					+ "\n[4] -► Uscita"					
					);
					
			
			 scelta = scan.nextInt(); 
			}
			while(scelta < 1 || scelta > 4); 
		
		if(scelta == 1) {
			int sceltaAlbum;
			do {
				System.out.println("Che cosa vuoi fare: "
						+ "\n[1] -► Aggiungere album"
						+ "\n[2] -► Leggere album"
						+ "\n[3] -► Aggiornare album"
						+ "\n[4] -► Eliminare album"
						);	
				
				 sceltaAlbum = scan.nextInt(); 
			}
			while(sceltaAlbum < 1 || sceltaAlbum > 4);
			
		switch(sceltaAlbum) {
			
			case 1: 
				alb1.addAlbum(alb);
				break; 
			case 2: 
				List <Album> listaAlbum = alb1.readAlbum();
				break;
				
			case 3: 
				alb1.updateAlbum();
				break;
			
			case 4: 
				alb1.deleteAlbum();
				break; 
				
			default: 
				System.out.println("arrivederci");
			
		}
	}
		else if(scelta == 2) {
			int sceltaBrani; 
			
			do {
				System.out.println("Che cosa vuoi fare: "
						+ "\n[1] -► Aggiungere brani"
						+ "\n[2] -► Leggere brani"
						+ "\n[3] -► Aggiornare brani"
						+ "\n[4] -► Eliminare brani"
						);	
				
				 sceltaBrani = scan.nextInt();
				
			}
			while(sceltaBrani < 1 || sceltaBrani > 4); 
			
		switch(sceltaBrani) {
			case 1: 
				brn1.addBrani(brano);
				break; 
				
			case 2: 
				List <Brani> listaBrani = brn1.readBrani(); 
				break;
				
			case 3: 
				brn1.updateBrani();
				break; 
			
			case 4: 
				brn1.deleteBrani();
				break;
				
				default: 
					System.out.println("Arrivederci");		
		}
			
		}
		else {
			int sceltaGenere;
			do {
				System.out.println("Che cosa vuoi fare: "
						+ "\n[1] -► Aggiungere genere"
						+ "\n[2] -► Leggere genere"
						+ "\n[3] -► Aggiornare genere"
						+ "\n[4] -► Eliminare genere"
						);	
				
				sceltaGenere = scan.nextInt(); 
			}
			while(sceltaGenere < 1 || sceltaGenere > 4);
			
		switch(sceltaGenere) {
			case 1: 
				gnr1.addGenere(genere);
				break;
			
			case 2:
				List <Genere> listaGenere = gnr1.readGenere(); 
				break;
				
			case 3: 
				gnr1.updateGenere();
				break;
			
			case 4: 
				gnr1.deleteGenere();
				break; 
				
			default: 
				System.out.println("Arrivederci");			
		
		}
			
		}
			
		
  }
}

