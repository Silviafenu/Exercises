package it.corsoAccenture.Libreria.Utilities;

import java.time.LocalDate;
import java.util.Scanner;

public class Console {
	private static Scanner scan = new Scanner(System.in);
	
	public static Integer valoreIntero() {
		int numInt = 0; 
		String stringa = recuperaStringa();

		do {
			try {
					System.out.println("Inserisci il numero intero: ");
					Integer.parseInt(stringa);
				} catch (NumberFormatException e) {
					System.out.println("numero NON valido!");
				}
		}while(numInt < 0 );
		
		scan.nextLine();
		return numInt; 
	}
	
	public static Double valoreDouble() {
		double numDouble = 0.0; 
		String stringa = recuperaStringa();

		do {
			try {
					System.out.println("Inserisci il numero double: ");
					Double.parseDouble(stringa);
				} catch (NumberFormatException e) {
					System.out.println("numero NON valido!");
				}
		}while(numDouble < 0);
		
		scan.nextLine(); 
		return numDouble; 
	}
	
	public static Float valoreFloat() {
		float numFloat = 0; 
		String stringa = recuperaStringa();
		
		do {
			try {
					System.out.println("Inserisci il numero float: ");
					Float.parseFloat(stringa);
				} catch (NumberFormatException e) {
					System.out.println("numero NON valido!");
				}
		}while(numFloat < 0);
		
		scan.nextLine(); 
		return numFloat; 
	}
	
	public static Long valoreLong() {
		long numLong = 0; 
		String stringa = recuperaStringa();
		
		do {
			try {
					System.out.println("Inserisci il numero long: ");
					Long.parseLong(stringa);
				} catch (NumberFormatException e) {
					System.out.println("numero NON valido!");
				}
		}while(numLong < 0);
		
		scan.nextLine(); 
		return numLong; 
	}
	
	public static Boolean valoreBooleano() {
		boolean bool = false ; 
		String stringa = recuperaStringa(); 
		
			try {
					System.out.println("Inserisci il numero long: ");
					Boolean.parseBoolean(stringa);
				} catch (NumberFormatException e) {
					System.out.println("numero NON valido!");
				}
		return bool; 
	}
	

	public static Character valoreCharacter() {
		char carattere = ' ';
		String stringa = recuperaStringa();
		
		try {
					System.out.println("Inserisci un carattere: ");
					Character.valueOf(carattere);
				} catch (NumberFormatException e) {
					System.out.println("carattere non valido!");
				}
		return carattere; 
	}
	
	private static String recuperaStringa() {
		String varStringa = " "; 
		varStringa = scan.nextLine();
		
		return varStringa; 	
	}
	
	
	public static LocalDate restituisciData() {
		String data = recuperaStringa();
		try {
		String[] data2 = data.split("-"); //creo array per la data
		int giorni = Integer.valueOf(data2[0]); 
		int mesi = Integer.valueOf(data2[1]);
		int anni = Integer.valueOf(data2[2]); 
		
		LocalDate ld = LocalDate.of(anni,mesi,giorni);
		
		return ld;
		}
		catch(NumberFormatException e) {
			System.out.println("ERRORE");
		}
		return null; 
	}
	
	

}
