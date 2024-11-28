package Lezione5Oggetti.EsercizioVendita;
import java.util.Scanner;

public class Vendita {
	public static Scanner scan = new Scanner(System.in);

	private int numArticoliVenduti; 
	private double totVendite;
	private double totScontati;
	private double prezzoArticolo;
	private int quantita; 
	private double scontoPercentuale; 
	
	//costruttore con i parametri 
	public Vendita(int numArticoliVenduti, double totVendite, double totScontati, double prezzoArticolo, int quantita,  double scontoPercentuale) {
		super(); 
		this.numArticoliVenduti = numArticoliVenduti;
		this.totVendite = totVendite;
		this.totScontati = totScontati;
		this.prezzoArticolo = prezzoArticolo;
		this.quantita = quantita; 
		this.scontoPercentuale = scontoPercentuale;
	}
	
	//costruttore senza parametri 
	public Vendita() {
		super();
	}

	//METODO GETTER
	public int getNumArticoli() {
		return numArticoliVenduti;
	}

	public double getTotVendite() {
		return totVendite;
	}

	public double getTotScontati() {
		return totScontati;
	}

	public double getPrezzoArticolo() {
		return prezzoArticolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public double getScontoPercentuale() {
		return scontoPercentuale;
	}
	
	//METODO SETTER
	public void setNumArticoliVenduti(int numArticoliVenduti) {
		this.numArticoliVenduti = numArticoliVenduti;
	}
	
	public void setTotVendite(double totVendite) {
		this.totVendite = totVendite;
	}
	
	public void setTotScontati(double totScontati) {
		this.totScontati = totScontati;
	}
	
	public void setPrezzoArticolo(double prezzoArticolo) {
		this.prezzoArticolo = prezzoArticolo;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public void setScontoPercentuale(double scontoPercentuale) {
		this.scontoPercentuale = scontoPercentuale;
	}

	public void registraVendita(int n) {
		double prezzoFinale = prezzoArticolo; 
		if(n > quantita) {
			//calcolo sconto
			double sconto = prezzoArticolo * (scontoPercentuale/100);
			//prezzo scontato 
					prezzoFinale = prezzoArticolo - sconto;
					totScontati += sconto * n;
		}
		//aggiungo alle vendite
		totVendite += prezzoFinale * prezzoArticolo; 
		//aggiungo articoli ai venduti
		numArticoliVenduti += n; 
		
	}
	
	public void mostraVendite() {
		//stampa di tutto 
		System.out.println("\n Il totale dei prodotti scontati è: " + totScontati);
		System.out.println("\n Il numero dei prodotti venduti è: " + numArticoliVenduti);
		System.out.println("\n Il totale dei prodotti venduti è: " + totVendite);


		

		
	}
}
