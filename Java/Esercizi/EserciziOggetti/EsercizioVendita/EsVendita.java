package Lezione5Oggetti.EsercizioVendita;

import java.util.Scanner;

public class EsVendita {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Inserisci il numero di prodotti che vuoi comprare: ");
		int numArticoliVenduti = scan.nextInt(); 
		
		System.out.println("Inserisci la quantita dei prodotti: ");
		int quantita = scan.nextInt();
		
		System.out.println("Inserisci il prezzo dei prodotti: ");
		double prezzoArticolo = scan.nextDouble(); 
		
		System.out.println("Inserisci lo sconto del prodotto (%): ");
		double scontoPercentuale = scan.nextDouble(); 

		 Vendita vendita = new Vendita(); 
		vendita.setNumArticoliVenduti(numArticoliVenduti); 
		 vendita.setQuantita(quantita);
		 vendita.setPrezzoArticolo(prezzoArticolo);
		 vendita.setScontoPercentuale(scontoPercentuale);
		 
		 System.out.println("Inserisci il numero di articoli venduti alla prima vendita: ");
		 int articoliVenduti1 = scan.nextInt();
		 
		 vendita.registraVendita(articoliVenduti1);
		 vendita.mostraVendite();
		 
	}

}
