package Lezione4Metodi;
import java.util.Scanner; 

public class EsempiMetodi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		saluto();
		String s2 = saluto2();
		System.out.println(s2);
		
		int r = 20;
		int s = 10;
		int a = 15; 
		int b = 100;
		System.out.println(sommaInteri(r,s));
		System.out.println(sommaInteri(10,20));
		System.out.println(sommaInteri(b,a));
		
		//oppure 
		System.out.println("Inserisci i due numeri: ");
		System.out.println(sommaInteri(scan.nextInt(), scan.nextInt() ));
		
		
	}
	
	//metodo public: modificatore di visibilità
	// altro modificatori : static 
	// tipo di ritorno: void (senza ritorno) o il tipo di dato che deve restituire 
	// identificatore:  lunghezzaStringa
	//parametri
	
	public static void saluto() {
		System.out.println("ciao a tutti");
	}
	
	public static String saluto2() {
		String s = "ciao a tutti";
		System.out.println("ciao a tutti");
		return s;
	}
	
	public static int sommaInteri( int a, int b) {
		int somma = a + b; 
		return somma; 
	}
	
	
	// controllo se l'array è pieno
//	if ( arrNomi[arrNomi.length-1] != null) {
//		System.out.println("Array pieno");
//		return;
//	}
	
	
	

}
