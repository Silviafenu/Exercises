package Lezione3Array;
import java.util.Scanner; 

public class EsRimuoviDuplicati {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Inserisci il numero della lunghezza: ");
		int k = scan.nextInt();
		
		//riempimento primo array 
		char[] arr = new char[k]; 
		 System.out.println("Inserisci i caratteri: ");
		 for(int i = 0; i < k; i++) {
			 arr[i] = scan.next().charAt(0); //inserisco gli elementi dell'array
		 }
		 
		 //riempimento secondo array 
		 char[] arr2 = arr; 
		 System.out.println("Secondo array: " + String.valueOf(arr));
			 
		 
		 //confrontare i due array 
		 int size = 0;
		 int indTemp = 0;
		  //array di appoggio dove aggiungo gli elementi del seocndo array con i duplicati che diventa nulla 
		 for(int i = 0; i < arr.length - 1;  i++) {
			 for(int j = i + 1; j < arr.length; j++){
				 if(arr[i] == arr2[j]){
					 arr2[j] = '\0';
		    }
		}
	}
		//verifico le parole rimaste, quindi la nuova dimensione del array3
			for(int l = 0; l < arr2.length; l++) {
				if(arr[l] != '\0' ) {
					size++;
				}
			}
			 System.out.println(" Parole rimaste: " + size);
			
			//controllo se in arr2 c'è un carattere valido lo inserisco in arr3
			char[] arr3 = new char[size]; 
			for(int v = 0; v < k; v++) {
				if(arr2[v] != '\0' ) {
					arr3[indTemp] = arr[v];
					indTemp++;
				}
			}
				 
			 //stampa array senza duplicati 
			 System.out.println(" Array senza duplicati: ");
		        for (int n = 0; n < size ; n++){
		            System.out.println(arr3[n]);
		        }			 
			 
		 scan.close();
	 	    
	}
}


