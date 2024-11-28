package it.corsoAccenture.GestioneOrdini.View;
import it.corsoAccenture.GestioneOrdini.Entities.GestioneOrdini;
import it.corsoAccenture.GestioneOrdini.Entities.Ordine;

import java.util.Scanner;


public class Menu {
	private static Scanner scan = new Scanner(System.in);

	public void startMenu(){

		int scelta; 
		int idOrdine;
		String cliente;
		String dataOrdine; 
		double importoTotale;
		String stato = null;
		
		
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
			
			System.out.println("********* ►GESTIONE ORDINI:◄ **********\n"
					+ "*1 -► Aggiungi nuovi ordini             ◄*\n"
					+ "*2 -► Cercare un ordine per ID.         ◄*\n"
					+ "*3 -► Aggiornare lo stato di un ordine. ◄*\n"
					+ "*4 -► Rimuovere un ordine dato l'ID.    ◄*\n"
					+ "*5 -► Stampare tutti gli ordini.        ◄*\n"
					+ "*********************************");
			System.out.println("\n Che vuoi fare?");
			scelta = scan.nextInt();
			scan.nextLine();
			
			switch(scelta) {
				case 1: 
					System.out.println("\n Inserisci il codice ID: ");
					idOrdine = scan.nextInt();
					scan.nextLine();
					System.out.println("\n Inserisci il nome cliente: ");
					cliente = scan.nextLine();
					System.out.println("\n Inserisci la data dell'ordine: ");
					dataOrdine = scan.nextLine();
					System.out.println("\n Inserisci l'importo dell'ordine: ");
					importoTotale = scan.nextDouble();
					scan.nextLine();
				     stato = "In elaborazione";

					
					Ordine ordine = new Ordine(idOrdine, cliente, dataOrdine, importoTotale, stato );
					aggiungiNuoviOrdini(ordine);
					
					break;
					
				case 2: 
					System.out.println("\n Inserisci il codice ID che devi ricercare: ");
					int ID = scan.nextInt();
					scan.nextLine();
					
					cercaOrdine(ID);
					
					break; 
					
				case 3: 
					System.out.println("\n Inserisci il codice ID per aggiornare lo stato: ");
					int ID2 = scan.nextInt();
					scan.nextLine();
					aggiornaStatoOrdine(ID2);
					
					break; 
					
				case 4: 
					System.out.println("\n Inserisci il codice ID per rimuovere l'ordine: ");
					int ID3 = scan.nextInt();
					scan.nextLine();
					rimuovereOrdine(ID3);
					
					break; 
					
				case 5:
					stampaOrdini(); 
					break; 
					
					default: 
						System.out.println("ADDIOS");
	
					}
		}
			while(scelta != 5);
	}

	private void stampaOrdini() {
		
	}

	private void rimuovereOrdine(int iD3) {
		
	}

	private void aggiornaStatoOrdine(int iD2) {
		
	}

	private void cercaOrdine(int iD) {
		
	}

	private void aggiungiNuoviOrdini(Ordine ordine) {
		
	}
}	
