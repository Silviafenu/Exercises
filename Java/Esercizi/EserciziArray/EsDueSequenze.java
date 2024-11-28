package Lezione3Array;
import java.util.Scanner; 


public class EsDueSequenze {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		String[] seq1 = new String[5];
		String[] seq2 = new String[5];
		
		 
		 //serve solo per ciclare le parole 
		 System.out.println("Inserisci la prima sequenza di parole: \n");
		 for(int i = 0; i < seq1.length; i++) {
			 seq1[i]= scan.nextLine(); 						
		 }
		 
		 
		 System.out.println("Inserisci la seconda sequenza di parole: ");
		 for(int i = 0; i < seq2.length; i++) {
			 seq2[i]= scan.nextLine();
		 }
		 
		 //una volta che ho le parole ciclo per confrontare le due sequenze 
		 int i = 0;
		 for( i = 0; i < seq1.length; i++) {
			 for(int j = 0; j < seq2.length; j++){
				 if(seq1[i].equals(seq2[j])) { //confronto gli indici di ciascun array
					 System.out.println("OK");
					 i=5;
					 
					 break;
				 }
				
			 }
		 }
		 if(i != 6) {
			 System.out.println("NO");
		 }
		 
		 
		 scan.close();
		 
	}

}
