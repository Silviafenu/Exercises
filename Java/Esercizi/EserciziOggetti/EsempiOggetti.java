package Lezione5Oggetti;

public class EsempiOggetti {
	public static void main(String[] args) {
		
		String nome = "Mario"; //variabile locale
		                  //costruttore di default senza parametri
		Persona p1 = new Persona(); //tipodiDato identificatore = new matodoCostruttore();
		p1.nome = "Sandro"; //variabile d'istanza 
		p1.cognome = "Rossi";
		//p1.eta = 30;  //non posso entrare poichè è private 
		p1.setEta(30); 
		
		
		EsempiOggetti es1 = new EsempiOggetti(); //istanza di una classe 
		
		Persona p2 = new Persona("Michela", "Rossi", 27); 
		
		//override definisce un comportamneto che si sta ripetendo, ad esempio metodo toString
		
				
		
		
	}
	
}

