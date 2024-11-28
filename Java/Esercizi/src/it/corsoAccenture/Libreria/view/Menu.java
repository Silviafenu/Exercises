package it.corsoAccenture.Libreria.view;

import java.time.LocalDate;
import java.util.Scanner;

import it.corsoAccenture.Libreria.Utilities.Console;
import it.corsoAccenture.Libreria.entities.Libreria;
import it.corsoAccenture.Libreria.entities.Libro;


public class Menu {

	private static Scanner scan = new Scanner(System.in);


	public void startMenu(){
		Libreria libreria = new Libreria();
		libreria.inserimentoLibro(new Libro("La divina commedia", "Dante Alighieri", 15.30, LocalDate.of(2000, 1, 1)));
		libreria.inserimentoLibro(new Libro("Odissea", "Omero", 11.47, LocalDate.of(1988, 12, 9)));
		libreria.inserimentoLibro(new Libro("La casa dei silenzi", "Donato Carrisi", 21.85, LocalDate.of(2024, 10, 29)));
		
		for(int i = 0; i < libreria.getLibri().size(); i++) {
			System.out.println("\n Libri disponibili: "+ libreria.getLibri().get(i));
		}

		int scelta = 0; 
		String titolo; 
		String autore;
		double prezzo;
		LocalDate data; 
		
	do {	
			
			System.out.println("                                        \r\n"
					+ "  ____    __  ______  ____   _  __   _  \r\n"
					+ " |    \\  /  ||   ___||    \\ | ||  | | | \r\n"
					+ " |     \\/   ||   ___||     \\| ||  |_| | \r\n"
					+ " |__/\\__/|__||______||__/\\____||______| \r\n"
					+ "                                        \r\n"
					+ "                                        \r\n"
					+ "\r\n"
					+ "");
			
			System.out.println("********* ►🏛️ LIBRERIA: 🏛️◄ **********\n"
					+ "*1 -► Inserisci libro                       ◄*\n"
					+ "*2 -► Elimina libro                         ◄*\n"
					+ "*3 -► Cerca libro                           ◄*\n"
					+ "*4 -► Restituzione differenza               ◄*\n"
					+ "*5 -► Serializzazizone e Deserializzazione  ◄*\n"
					+ "*********************************");
			System.out.println("\n Che vuoi fare?");
			scelta = scan.nextInt();
			scan.nextLine();
			
		switch(scelta) {
			case 1: 
				System.out.println("\n Inserisci il titolo del libro: ");
				titolo = scan.nextLine();
				System.out.println("\n Inserisci l'autore del libro: ");
				autore = scan.nextLine();
				System.out.println("\n Inserisci il prezzo del libro: ");
				prezzo = scan.nextDouble();
				scan.nextLine();
				System.out.println("\n Inserisci la data di uscita del libro (dd-mm-yyyy): ");
				data = Console.restituisciData();
				
				Libro libro = new Libro(titolo, autore, prezzo, data); 
				
				libreria.inserimentoLibro(libro);
				break;
				
			case 2: 
				System.out.println("\n Inserisci il titolo del libro DA ELIMINARE: ");
				String titoloEliminare = scan.nextLine();
				
				libreria.eliminazioneLibro(titoloEliminare);
				break; 
				
			case 3: 
				System.out.println("\n Inserisci l'anno del libro DA RICERCARE: ");
				int anno = scan.nextInt();
				
				libreria.ricercaLibro(anno);
				break; 
				
			case 4: 
				System.out.println("\n Inserisci il titolo del primo libro: ");
				String titolo1 = scan.nextLine();
				System.out.println("\n Inserisci il titolo del secondo libro: ");
				String titolo2 = scan.nextLine();
				
				libreria.ritornaDifferenza(titolo1, titolo2); 
				break; 
				
			case 5: 
				libreria.salvataggiosuFile();
				break; 
			default: 
					System.out.println("ARRIVEDERCI");	
				    break; 
				
			}
				
	}while(scelta != 5); 
		
}
}
