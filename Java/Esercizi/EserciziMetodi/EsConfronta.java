package Lezione4Metodi;
import java.util.Scanner; 

public class EsConfronta {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Confronta();
		System.out.println(num);
		
		
		//inserisco i numeri da tastiera
		System.out.println("Inserisci i tre numeri: ");
		System.out.println("Il numero massimo è: "+ Confronta(scan.nextInt(), scan.nextInt(), scan.nextInt()));
		
		
	}
	
	public static int Confronta() {
		Scanner scan = new Scanner(System.in);

		int numMax = 0; 
		 //inserisco i numeri 
	    System.out.println("Inserisci i numeri: ");
	    int  num1 = scan.nextInt();
	    int num2 = scan.nextInt();
	    int num3 = scan.nextInt();
	    
	    //trovo il maggiore
	    if(num1 > num2 && num1 > num3) {
	    	numMax = num1; 
	    	System.out.println("Il numero maggiore è: " + num1);
	    }
	    else if(num2 > num3 && num2 < num1  ) {
	    	numMax = num2;
	    	System.out.println("Il numero maggiore è: " + num2);
	    }
	    else {
	    	numMax = num3;
	    	System.out.println("il numero maggiore è: " + num3);
	    }
	    
	    return numMax; 
	}
	
	public static int Confronta(int num1, int num2, int num3) {
		//trovo il numero maggiore 
		int numMax = 0;
		   if(num1 > num2 && num1 > num3) {
		    	numMax = num1; 
		    }
		    else if(num2 > num3 && num2 < num1  ) {
		    	numMax = num2;
		    }
		    else {
		    	numMax = num3;
		    }
		   return numMax; 
	}
}		
