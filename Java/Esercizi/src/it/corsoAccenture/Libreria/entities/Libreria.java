package it.corsoAccenture.Libreria.entities;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



public class Libreria {
	ArrayList<Libro> insiemeLibri = new ArrayList<Libro>(); 
	

	public void inserimentoLibro(Libro libro) {
		boolean trovato = true; 
		for(int i = 0; i < insiemeLibri.size(); i++) {
				if(libro.getTitolo().equals(insiemeLibri.get(i).getTitolo()) ) {
					System.out.println("Il libro non puo essere aggiunto perchè titolo uguale");
					trovato = false; 
				}
			}
		
		if(trovato == true) {
			insiemeLibri.add(libro);
			 System.out.println(" Libro inserito all'interno della libreria");
	}
	}
	
	public ArrayList<Libro> getLibri(){
		return this.insiemeLibri; 
	}
	
	public void eliminazioneLibro( String titoloRichiesto) {
		boolean rimosso = true; 
		for(int i = 0; i < insiemeLibri.size(); i++) {
			if(titoloRichiesto != null && titoloRichiesto.equals(insiemeLibri.get(i).getTitolo()) ) {
				insiemeLibri.remove(i);	
				System.out.println("Il libro è stato rimosso dalla libreria");
				rimosso = false; 
			}
		}	
			if(rimosso == true) {
				System.out.println("Libro non trovato");
			}
		

	}
	
	
	public void ricercaLibro(int annoRichiesto) {
		for(int i = 0; i < insiemeLibri.size(); i++) {
			if(insiemeLibri.get(i).getDataUscita().getYear() == annoRichiesto) {
				System.out.println("\n Libro trovato: " + insiemeLibri.get(i).toString());
				
			}
			else {
				System.out.println("\n Libro NON TROVATO");
			}
		}
		
		
	}
	

	public long ritornaDifferenza(String titolo1, String titolo2) {
		LocalDate data1 = null, data2 = null; 
		long risultato; 
		try {
		for(int i = 0; i < insiemeLibri.size(); i++) {
			if(insiemeLibri.get(i).getTitolo() == titolo1) {
				data1 = insiemeLibri.get(i).getDataUscita();
			}
		}
		for(int i = 0; i < insiemeLibri.size(); i++) {
			if(insiemeLibri.get(i).getTitolo() == titolo2) {
				data2 = insiemeLibri.get(i).getDataUscita();
			}
		}
		risultato = ChronoUnit.YEARS.between(data1, data2);
		
		return risultato;
		}
		catch(Exception e) {
			System.out.println("ERRORE!!!!!!!!");
			
			return Long.MIN_VALUE; //numero a caso per non stampare quel valore 
		}
		
	}

	public void salvataggiosuFile() {
		//creazione cartella odve mettere il file
		File cartella = new File("C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Libreria");
		
		//creazione cartella
			if(!cartella.exists()) {
				cartella.mkdir();
				System.out.println("Cartella creata");
			}
		
		//creazione file Salvataggio
		File file1 = new File("C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Libreria\\File/Salvataggio.txt");
		
		if(!file1.exists()) {
			try {
				file1.createNewFile();
				System.out.println("File creato");
			} 
			catch (IOException e) {
				System.out.println("Non sono riuscito a creare un file");	
				}
			}
		
		//Serializzazione oggetto libro
		
		FileOutputStream fileOutput;
		try {
				fileOutput = new FileOutputStream(file1);
				ObjectOutputStream oos = new  ObjectOutputStream(fileOutput);
				
				//li passo l'oggetto
				oos.writeObject(insiemeLibri);  //LI PASSO L'ARRAYLIST
				System.out.println("Oggetto SERIALIZZATO CORRETTAMENTE");
				fileOutput.close();
				oos.close(); 
			}
		catch (FileNotFoundException e) {
			 	System.out.println("File non trovato");		
			 	} 
		catch (IOException e) {
			 	System.out.println("Non posso recuperare gli oggetti all'interno del file");	
			}
		
		//deserializzazione per prendere l'oggetto
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(file1);
			ObjectInputStream ois = new ObjectInputStream(fileInput);
			 
			
			ArrayList<Libro> lib  = (ArrayList<Libro>)ois.readObject();
			System.out.println("\n Oggetto DESERIALIZZATO");
			System.out.println(lib);
			
			
			fileInput.close();
			ois.close();		
			
		}
		catch (FileNotFoundException e) {
		 	System.out.println("File non trovato");		
		} 
		catch (IOException e) {
			 	System.out.println("Non posso recuperare gli oggetti all'interno del file");	
		} 
		catch (ClassNotFoundException e) {
			 System.out.println("Le instanze della classe ricercata non è presente all'interno del file");
		} 

}
}
