package Lezione3Array;
import java.util.Scanner; 


public class EsContaFamiglie {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Inserisci un numero delle famiglie: ");
		int k_famiglie = scan.nextInt(); 
		
		double[] redditi = new double[k_famiglie]; //k = numero famiglie 
		
		double reddito = 0; 
		
		double redditoMax = 0; 
		
		int countFamiglie = 0; 
		
		//inserisco i redditi delle famiglie
		for(int i = 0; i < k_famiglie; i++) {
				System.out.println("Inserisci il reddito: ");
				reddito = scan.nextDouble();
				
			if( reddito > 100000) {
				System.out.println("Inserisci un valore minore di 100000");
			 }
			redditi[i] = reddito; //inserisco i valori di reddito nell'array
		}		
			
		int indMax = 0;
			for(int i = 0;  i < k_famiglie ; i++) {				
				System.out.println("I valori sono: " + redditi[i]);
				
				//trovo reddito max
		
				if(redditi[i] > redditoMax) {
					redditoMax = redditi[i];
					indMax = i;
				   }
	    		}
			   System.out.println("Il reddito max è: " + redditoMax);
			   
				double redditoInf = redditoMax * 0.90; //calcolo il reddito inferiore del 10% di redditoMax
				
				//trovo le famiglie che hanno il reddito inferiore
				for(int i = 0; i < k_famiglie; i++ ) { 
						if(redditi[i] >= redditoInf && i != indMax) {
							countFamiglie++;
						}
					}
				System.out.println("Il reddito inferiore è: " + redditoInf);
				
				//stampa finale
				System.out.println("Le famiglie che hanno reddito inferiore sono: "  + countFamiglie);
				for(int i = 0; i < redditi.length; i++) {
					System.out.println("E i loro redditi sono: " + redditi[i]);
				}
				
		 }
}
			
		


