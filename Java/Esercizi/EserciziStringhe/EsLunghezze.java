package Lezione2Stringhe;
import java.util.Scanner;


public class EsLunghezze {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String stringhe; 
		int somma = 0; 
		
		do {
		System.out.println("Inserisci una sequenza di stringhe: ");
		stringhe = scan.nextLine();
		
		if(Character.isUpperCase(stringhe.charAt(0))){
			somma += stringhe.length();
		}
		
		}
		while(!stringhe.equals(" "));
		
		
		System.out.println("La somma finale è: " + somma );
		
		
		scan.close();
	}

}

/* oppure 
do {
if(!stringhe.equals(" ")){
	paorlaMaiuscolo = parola.toUppercase();
	if(parola.charAt(0) == parolaMaiuscolo.charAt(0)){
	somma += stringhe.length();
}
}

}
while(!stringhe.equals(" "));
*/