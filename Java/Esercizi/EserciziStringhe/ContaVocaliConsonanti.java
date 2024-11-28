package Lezione2Stringhe;
import java.util.Scanner;

public class ContaVocaliConsonanti {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//prendo la frase 
		System.out.println("Inserisci la frase: ");
		String frase = scan.nextLine(); 
		
		int contaVocali = 0;
		int contaConsonanti = 0; 
		
		String vocali = "AEIOUaeiou";
		
		//controllo ogni carattere della frase
		for(int i= 0; i < frase.length(); i++) {
			 if (vocali.contains(String.valueOf(frase.charAt(i)))) { //controllo se sono presenti le vocali nella frase e conto le vocali 
				 contaVocali++;
             }
			 //controllo spazi sennò vado avanti
			 else if(frase.charAt(i) == ' '){
				 continue;
			 }
			 else if(Character.isLetter(frase.charAt(i))){ //controllo per ciascun carattere all'interno della frase se è una lettera (a-z) e conto le consonanti
				 contaConsonanti++;
             }
		}
		
		System.out.println("Numero di vocali: " + contaVocali);
        System.out.println("Numero di consonanti: " + contaConsonanti);
        
       scan.close();

	}
}


