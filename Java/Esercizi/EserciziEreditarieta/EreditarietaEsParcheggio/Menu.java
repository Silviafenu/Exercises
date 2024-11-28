package Lezione6EreditarietaEsParcheggio;

import java.util.Scanner;

public class Menu {
	private static Scanner scan = new Scanner(System.in);
	private static final int MAX_CAPIENZA = 10;
	private static Parcheggio park1 = new Parcheggio(MAX_CAPIENZA);
	
public static void startMenu(){
	 int comando;
	
	do {
		System.out.println("\n Cosa vuoi fare:\n 1)Entra Vettura \n 2)Esce Vettura \n 3)Aggiorna Ora \n 4)Promozioni  \n 5)Macchine con più ore \n 6)Uscita Programma");
		System.out.println("Sono le ore: " + park1.getOraCorrente());

		comando = scan.nextInt();
		
		switch(comando) {
		case 1: 
			park1.entraVettura();
			break;
		case 2: 
			park1.esceVettura();
			break;
		case 3: 
			park1.aggiornaOra();
			break;
		case 4: 
			park1.promozioni();
			break;
		case 5:
			park1.getVetture();
			break;
		case 6: 
			System.out.println("USCITA PROGRAMMA");
			break; 
			default:
				break;
						
			}
		
		
	}
	while(comando != 6);
}
}


