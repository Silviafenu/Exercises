package it.corsoAccenture.GestionePrelievoBancario.View;

import java.util.Scanner;

import it.corsoAccenture.GestionePrelievoBancario.Entities.ContoBancario;

public class Menu {

	private static Scanner scan = new Scanner(System.in);

	public void startMenu(){
	int scelta = 0; 
	String nomeCliente; 
	String cognomeCliente; 
	double saldo = 0.0; 
	
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
		
		System.out.println("********* ►CONTO BANCARIO:◄ **********\n"
				+ "*1 -► Aggiungi cliente                  ◄*\n"
				+ "*********************************");
		try {
		System.out.println("\n Che vuoi fare?");
		scelta = scan.nextInt();
		scan.nextLine();
		}catch(Exception e) {
			System.out.println("ERRORE");
	}
	}
	while(scelta != 1); 
	
		if(scelta == 1) {
			try {
				System.out.println("\n Inserisci il nome del cliente: ");
				nomeCliente = scan.nextLine();
				System.out.println("\n Inserisci il cognome del cliente: ");
				cognomeCliente = scan.nextLine();
				System.out.println("\n Inserisci il saldo nel conto: ");
				saldo = scan.nextDouble();
				scan.nextLine();

				System.out.println("puoi fare due operazioni: \n1)Prelevare \n2)Depositare");
				int operazioni = scan.nextInt(); 
				scan.nextLine();
				
				ContoBancario conto1 = new ContoBancario(nomeCliente,cognomeCliente, saldo);
				conto1.toString();
				
				switch(operazioni) {
					case 1: 
						System.out.println("Inserisci la cifra che vuoi prelevare: ");
						int importo = scan.nextInt();
						conto1.prelievo(importo);
						 
						break; 
					case 2: 
						System.out.println("Inserisci la cifra che vuoi depositare: ");
			        	int sommaDenaro = scan.nextInt();
			        	conto1.deposito(sommaDenaro);
						break;
						
						default: 
							System.out.println("ARRIVEDERCI");	
				}
			}
				catch(Exception e) {
					System.out.println("ERRORE");
				}				
		   }
	}
}




