package Lezione6EreditarietaEsParcheggio;

import java.util.Scanner;
import java.util.Random;


public class Parcheggio {
	private static Scanner scan = new Scanner(System.in);
	private static Random random = new Random();
	private int numPosti;
	private Veicolo[] veicoli ; 
	private static short oraCorrente;
	private static Veicolo[] zonaRimozione;
	private int countRimossi = 0; 
	private short orePagate;
	
	
	public Parcheggio(int numPosti) {
		super(); 
		this.setNumPosti(numPosti); 
		veicoli = new Veicolo[numPosti]; 	
		zonaRimozione = new Veicolo[numPosti];
	}

	//metodo GETTER 
	public int getNumPosti() {
		if(numPosti < 0) {
			System.out.println("Numero posti non valido, riprova");
			numPosti = scan.nextInt(); 
		}
		return numPosti;
	}

	public Veicolo[] getVeicoli() {
		return veicoli;
	}
	
	public static Veicolo[] getZonaRimozione() {
		return zonaRimozione;
	}

	public static short getOraCorrente() {
		return oraCorrente;
	}
	
	public short getOrePagate() {
		return orePagate;
	}


	//Metodo SETTER
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public void setVeicoli(Veicolo[] veicoli) {
		this.veicoli = veicoli;
	}

	public static void setZonaRimozione(Veicolo[] zonaRimozione) {
		Parcheggio.zonaRimozione = zonaRimozione;
	}


	public void setOrePagate(short orePagate) {
		this.orePagate = orePagate;
	}

	public static void setOraCorrente(short oraCorrente) {
		if(oraCorrente > 23) {
			oraCorrente = 0;
		}
		Parcheggio.oraCorrente = oraCorrente;
	}

	public boolean isLibero() {
		for(int i = 0; i < getVeicoli().length; i++) {
			if(getVeicoli()[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	
	public void entraVettura() {

		//controllo se il parcheggio è vuoto e inserisco il veicolo nel parcheggio 
	if(isLibero()){
		//richiedo le informazioni di veicolo
		Veicolo veicolo = new Veicolo();
		System.out.println("\n Inserisci la targa: ");
		veicolo.setTarga(scan.nextLine().toUpperCase());
		
		 veicolo.setOraArrivo(oraCorrente);
		 
		 System.out.println("\n Inserisci l'orario di uscita: ");
		 veicolo.setOraScadenza(scan.nextShort());
		scan.nextLine();	
		
	for(int i = 0; i < getVeicoli().length; i++) {
			if(getVeicoli()[i] == null) {
				//aggiungo la macchina al posto vuoto 
				getVeicoli()[i] = veicolo;
				break;
			}
		}
	}else {
			System.out.println("Il parcheggio è PIENO");
		}	
	}		
	
	public void esceVettura() {
		boolean uscita = false;
		
		System.out.println("Qual'è la tua targa da rimuovere : ");
		String targaTemp = scan.nextLine().toUpperCase();
		 
		//ricerco la targa all'interno dell'array e se è uguale togli il veicolo 
		for(int i = 0; i < getVeicoli().length; i++) {
			
			if(getVeicoli()[i] != null && getVeicoli()[i].getTarga().equals(targaTemp) ) {
				getVeicoli()[i] = null;
				System.out.println("Macchina uscita dal parcheggio ");
				uscita = true;
				break;
			}			
		}
		if(uscita) {
			System.out.println("Macchina uscita correttamente");
		}
		else {
			System.out.println("Macchina non trovata");
		}
	}
	
	
	public void aggiornaOra() {
		setOraCorrente((short)(getOraCorrente()+1)); 
		for(int i = 0; i< getVeicoli().length; i++) {
			if(getVeicoli()[i] != null && getVeicoli()[i].getOraScadenza() == oraCorrente) {
				getZonaRimozione()[countRimossi] = getVeicoli()[i];
				countRimossi++;
				System.out.println("La macchina con targa: " +  getVeicoli()[i].getTarga() + "è stata spostata in zona Rimozione");
				getVeicoli()[i] = null; 								
			}
			
			
		}
	}
	
	public void getVetture() {
		short maxCountOre = 0; 
		for(int i = 0; i < getVeicoli().length; i++) {
			if(getVeicoli()[i] != null && getVeicoli()[i].totOreParcheggiate() > maxCountOre) {
				maxCountOre = getVeicoli()[i].totOreParcheggiate(); 
			}
		}
		System.out.println("Il massimo di ore parcheggiate è: "+ maxCountOre);

		for(int i = 0; i< getVeicoli().length; i++) {
			if(getVeicoli()[i] != null && getVeicoli()[i].totOreParcheggiate() == maxCountOre) {
				System.out.println("Il numero di macchine parcheggiate nell'ora più alta sono: " + getVeicoli()[i]);
			}
		}	
	}
	
	public void promozioni() {
		int min = 10; 
		int max = 99;
		int numDueCifre = random.nextInt(min-max) + max; 
		System.out.println("Le due cifre randomiche sono: " + numDueCifre);
	
		for(int i = 0; i< getVeicoli().length; i++) {
			if(getVeicoli()[i].getTarga().substring(4, 6).equals(String.valueOf(numDueCifre))) {
				getVeicoli()[i].incrementaOre(); 
				System.out.println("La macchina con targa: " + getVeicoli()[i].getTarga() + " ha vinto un'ora di parcheggio gratis ");
				
			}
		}

	}
	
	

	
	
}
