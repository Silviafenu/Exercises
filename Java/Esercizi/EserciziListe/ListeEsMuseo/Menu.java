package Lezione8ListeEsMuseo;

import java.util.Scanner;

public class Menu {
	private static Scanner scan = new Scanner(System.in);
	
	public static void startMenu(){
		Museo museo = new Museo();
		
		int scelta; 
		int codice = 0;
		String titolo;
		String autore;
		boolean esposta; 
		String tecnicaUsata;
		String materiale;
		double altezza;
		
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
			
			System.out.println("********* ►🏛️ MUSEO: 🏛️◄ **********\n"
					+ "*1 -► Carica Opera              ◄*\n"
					+ "*2 -► Sposta Opera              ◄*\n"
					+ "*3 -► Cerca Opera               ◄*\n"
					+ "*4 -► Stampa opere esposte      ◄*\n"
					+ "*5 -► Stampa opere nel deposito ◄*\n"
					+ "*********************************");
			System.out.println("\n Che vuoi fare?");
			scelta = scan.nextInt();
			scan.nextLine();
			
			switch(scelta) {
				case 1: 
					System.out.println("\n Inserisci il codice: ");
					 codice = scan.nextInt();
					 scan.nextLine();
					System.out.println("\n Inserisci il titolo: ");
					 titolo = scan.nextLine();
					System.out.println("\n Inserisci l'autore: ");
					 autore = scan.nextLine();
					 esposta = false; 
					
					
					System.out.println("\n Cosa vuoi inserire? \n 1)Quadro \n2)Statua");
					int comando = scan.nextInt(); 
					scan.nextLine();
					if(comando == 1) {
						System.out.println("\n Inserisci la tecnica usata: ");
						 tecnicaUsata = scan.nextLine();
						museo.carica(new Quadri(codice,titolo, autore, esposta, tecnicaUsata));
					}
					else {
						System.out.println("\n Inserisci il materiale usato: ");
						 materiale = scan.nextLine();
						 System.out.println("\n Inserisci l'altezza: ");
						 altezza = scan.nextDouble();
						 scan.nextLine();
						museo.carica(new Statue(codice,titolo,autore,esposta, materiale, altezza));
						System.out.println("Opera inserita");
					}
					break;					
			 
				case 2: 
					System.out.println("\n Inserisci il codice dell'opera da spostare: ");
					int codiceDaSpostare = scan.nextInt();
					scan.nextLine();
				
						if(codiceDaSpostare == codice) {
							museo.sposta(codiceDaSpostare);
							System.out.println("Opera spostata");
						}
						break; 
						
				case 3:
					System.out.println("\n Inserisci il codice dell'opera da cercare: ");
					int codiceDaCercare = scan.nextInt();
					scan.nextLine();
					
						if(codiceDaCercare == codice) {
							museo.cerca(codiceDaCercare);
					}
						break;
					
				case 4: 
					museo.stampaSala();
					break; 
					
				case 5: 
					museo.stampaDeposito();
					break; 
					
					default: 
						System.out.println("\n ADDIOS ");

			
			}	
		}

	while(scelta != 5);
	}
}
