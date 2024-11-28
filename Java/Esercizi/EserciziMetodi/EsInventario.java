package Lezione4Metodi;
import java.util.Scanner; 

//ricordati maiuscole e controlli sulle quantita e tutti i controlli possibili 

public class EsInventario {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 
		 int scelta = 0; 
		 
		 
		 int k = 5;
		 String[] arrNomi = new String[k]; 
		 double[] arrPrezzi = new double[k];
		 int[] arrQuantita = new int[k];
		 				 
		 
		 do {
			 System.out.println("Inserisci le operazioni che vuoi fare: \n 1)aggiungi un nuovo prodotto \n2)Ricerca di un prodotto \n3)Visualizza l'inventario \n4)Vendere un prodotto \n5)Uscire da un programma");
			 scelta = scan.nextInt();
			 
			 switch(scelta) {
			 case 1:
				 aggiungiProdotto(arrNomi, arrPrezzi, arrQuantita);
				 break;
			 case 2: 
				 ricercaProdotto(arrNomi, arrPrezzi, arrQuantita);
				 break;
			 case 3:
				 inventario(arrNomi, arrPrezzi, arrQuantita); 
				 break;
			 case 4:
				 vendereProdotto(arrNomi, arrPrezzi, arrQuantita);
				 break;
			 case 5:
				 uscitaProgramma();
				 break;
				 default:
					 break;
			 }
					 
		 } while(scelta != 5);
			 
		 
		}
	
	public static void aggiungiProdotto(String[] arrNomi, double[] arrPrezzi, int[] arrQuantita) {
		 Scanner scan = new Scanner(System.in);
		 
		 //richiesta nomi, quntita e prezzo 
		System.out.println("Inserisci il nome del prodotto che vuoi aggiungere: ");
		String nome = scan.nextLine().toLowerCase();
		System.out.println("Inserisci il prezzo del prodotto che vuoi aggiungere: ");
		double prezzo = scan.nextDouble();
		System.out.println("Inserisci la quantità del prodotto che vuoi aggiungere: ");
		int quantita = scan.nextInt();

		
		//ricerco l'indice per inserire il prodotto
		int index = 0;
		for (int i = 0; i < arrNomi.length; i++) {
			if ( arrNomi[i] == null ) { //cerco la cella vuoto dell'arrray e salvo l'indice 
				index = i;
				break;
			}
		}
		
		//aggiunta prodotti
		arrNomi[index] = nome;
		arrPrezzi[index] = prezzo; 
		arrQuantita[index] = quantita; 
		
		System.out.println("Il prodotto è stato aggiunto:  \n nome:  " + nome + " \n prezzo: " + prezzo + " \n quantita: " + quantita);
		
	}

	
	public static void ricercaProdotto(String[] arrNomi, double[] arrPrezzi, int[] arrQuantita) {
		Scanner scan = new Scanner(System.in);
		
		//richiedo il nome da ricercare all'interno dell'array Nomi
		System.out.println("Inserisci il nome del prodotto che vuoi ricercare: ");
		String nomeProdotto = scan.nextLine();
		
		//Ricerco il prodotto all'interno dell'array e stampo le informazioni riguardo il prodotto richiesto
		for(int i =  0; i < arrNomi.length; i++) {
			if ( arrNomi[i] == null ) { //verifica nel caso in cui l'array sia vuoto e non ci siano prodotti 
				continue;
			}
			
			//controllo se il prodotto è all'interno dell'array
			if(arrNomi[i].equals(nomeProdotto)) {
				System.out.println("Il prodotto è all'intermo dell'inventario:  \n nome:  " + arrNomi[i] + " \n prezzo: " + arrPrezzi[i] + " \n quantita: " + arrQuantita[i]);
			}
		}
		
		
	}

	public static void inventario(String[] arrNomi, double[] arrPrezzi, int[] arrQuantita) {
		for(int i = 0; i < arrNomi.length; i++) {
			if ( arrNomi[i] == null ) { //verifica nel caso in cui l'array sia vuoto e non ci siano prodotti 
				continue;
			}
			
			System.out.println("Prodotto: \n nome:  " + arrNomi[i] + " \n prezzo: " + arrPrezzi[i] + " \n quantita: " + arrQuantita[i]);
		}
		
	}
	
	public static void vendereProdotto(String[] arrNomi, double[] arrPrezzi, int[] arrQuantita) {
	Scanner scan = new Scanner(System.in);
		
		//richiedo il nome da vendere all'interno dell'array
		System.out.println("Inserisci il nome del prodotto che vuoi vendere: ");
		String nomeProdotto = scan.nextLine();
		
		//Ricerco il prodotto all'interno dell'array e stampo le informazioni riguardo il prodotto richiesto
		for(int i =  0; i < arrNomi.length; i++) {
			if ( arrNomi[i] == null ) { //verifica nel caso in cui l'array sia vuoto e non ci siano prodotti 
				continue;
			}
			//ricerco il nome del prodotto all'interno dell'array e lo elimino
			if(arrNomi[i].equals(nomeProdotto)) {
				if(arrQuantita[i] > 0) { //controllo in tal caso l'array fosse a 0
					arrQuantita[i]--;
				}				
			}
			
		}
		
	}
	
	public static void uscitaProgramma() {
		System.out.println("Uscita programma");
		
	}


}
