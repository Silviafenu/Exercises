package Lezione4Metodi;
import java.util.Scanner; 


public class EsPalindorma {

	public static void main(String[] args) {
		String frase = " ";

        boolean palindroma = Palindromo(frase);

	}
	
	public static boolean Palindromo(String par_fras) {		
		 Scanner scan = new Scanner(System.in);

		 //richiedo frase o parola
		  System.out.println("Inserisci la parola o la frase: ");
		  par_fras = scan.nextLine();
		  
		  
		  //controllo la parola dalla fine all'inizio 
		  par_fras  = par_fras.replaceAll(" ", "").toLowerCase(); //non considera gli spazi 
		  
		  for (int i = par_fras.length() - 1; i >= 0; i--) {
			  if(par_fras.charAt(i) != par_fras.charAt(par_fras.length() - i -1)) { //controllo ogni indice che deve essere diverso della frase che parte dalle fine
		          System.out.println("La parola/frase non è palindroma.");
				  return false; //non è palidroma 
			  }
	        }
          System.out.println("La parola/frase è palindroma.");
		  return true; // è palidroma
	}


}
