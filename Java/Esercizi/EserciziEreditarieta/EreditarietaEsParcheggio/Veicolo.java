package Lezione6EreditarietaEsParcheggio;

import java.util.Scanner;


public class Veicolo {
	private Scanner scan = new Scanner(System.in);
	private String targa; 
	private short oraArrivo; 
	private short oraScadenza;
	
	public Veicolo() {
		
	}
	
	public Veicolo(String targa, short oraArrivo, short oraScadenza) {
		super(); 
		this.targa = targa;
		this.oraArrivo = oraArrivo; 
		this.setOraScadenza(oraScadenza); 
	}

	//Metodo Getter
	public String getTarga() {
		return targa;
	}

	public short getOraArrivo() {
		return oraArrivo;
	}

	public short getOraScadenza() {
		return oraScadenza;
	}
	
	

	//Metodo Setter
	public void setTarga(String targa) {
		while(targa.length() != 7 || targa.substring(0, 2).matches("A-Z {2}") || targa.substring(6).matches("A-Z {2}") || targa.substring(2, 5).matches("[0-9] {3}") )  {
			System.out.println("Targa non valido, reinserisci la targa");
			targa = scan.nextLine();
		}
		
		this.targa = targa;
	}

	public void setOraArrivo(short oraArrivo) {
				while(oraArrivo < 0 || oraArrivo > 23) {
			System.out.println("Orario non valido, reinserisci un orario valido");
			oraArrivo = scan.nextShort();
		}
		this.oraArrivo = oraArrivo;
		
	}

	public void setOraScadenza(short oraScadenza) {
		while(oraScadenza < 0 || oraScadenza > 23) {
			System.out.println("Orario non valido, reinserisci un orario valido");
			oraScadenza = scan.nextShort();
		}
		this.oraScadenza = oraScadenza;
	
	}
	
	public void incrementaOre() {
		if(getOraScadenza() == 23) {
			oraScadenza = 0;
		}
	}
	
	public short totOreParcheggiate() {
		int result = 0;
		if(getOraScadenza() > Parcheggio.getOraCorrente()) {
				result = (short)((int)getOraScadenza() - (int)Parcheggio.getOraCorrente());		
		}
		else {
			result = 24 + (short)((int)getOraScadenza() - (int) Parcheggio.getOraCorrente());
		}
		return (short) result;
		
	}

	@Override
	public String toString() {
		return "Veicolo con targa=" + this.targa;
	}
	
	
	
}
