package Lezione3Array;
import java.util.Scanner; 

public class EsFrequenzaCarattere {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		int conteggio = 0; 
		
		String telefono; 
		System.out.println("Inserisci il numero di telefono: ");
		telefono = scan.nextLine(); 
		int[] numCifre = new int [10];

		
		for(int i = 0; i < telefono.length() ; i++) {
			 char c = telefono.charAt(i); 
			 
			 switch(c) {
			 	case '0': 
			 		numCifre[0]++;
			 		break;
			 	case '1': 
			 		numCifre[1]++;
			 		break;
			 	case '2': 
			 		numCifre[2]++;
			 		break;
			 	case '3': 
			 		numCifre[3]++;
			 		break;
			 	case '4': 
			 		numCifre[4]++;
			 		break;
			 	case '5': 
			 		numCifre[5]++;
			 		break;
			 	case '6': 
			 		numCifre[6]++;
			 		break;
			 	case '7': 
			 		numCifre[7]++;
			 		break;
			 	case '8': 
			 		numCifre[8]++;
			 		break;
			 	case '9': 
			 		numCifre[9]++;
			 		break;
			 	default:
			 		break; 
			 			
			 }
		}					
		
		for(int j = 0; j < numCifre.length; j++) {
			System.out.println("La cifra: " + j + " compare " + numCifre[j] ); 
		}
		
		scan.close();
	}

}
