package Lezione2Stringhe;
import java.util.Scanner;


public class EsSpaziVocali {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numTotSpazi = 0; 
		
		System.out.println("Inserisci la frase: ");
		String frase = scan.nextLine(); 
		
		String vocali = "AEIOUaeiou";
		
		for(int i = 0; i < frase.length(); i++) {
			if(frase.charAt(i)== ' ' && vocali.contains(String.valueOf(frase.charAt(i)))) {		
				numTotSpazi++;
			}
		}
		 System.out.println("Il numero di spazi seguiti da una vocale è: " + numTotSpazi);
		 
		 scan.close();
}
}



 /*oppure 
do {
	System.out.println("Inserisci la frase: ");
	String frase = scan.nextLine(); 
	lunghezza = frasde.lenght(); 
}while(lunghezza == 0)

//trovo indice del primo spazio 
	indiceSpazio = frase.indexOf(" ");
	
while(indiceSpazio != -1 && indiceSpazio < frase.lenght()-1 {
	lettera = frase.charAt(indiceSapzio +1);
	 // trasformo la frasde in to upper case
	  
	  if(lettera == 'A'  || lettera == 'E' || lettera == 'I'  || lettera == 'O'  || lettera == 'U' ){
	  spazi++;
	  }
	  
	  puntoDiapartenza =indiceDiPartenza++;
	  
	  //indice dello spazio successivo 
	  indiceSpazio = frase.indixOf(" ", puntoDiPartenza)
	  }
	  */

