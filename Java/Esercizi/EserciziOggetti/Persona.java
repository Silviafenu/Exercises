package Lezione5Oggetti;

public class Persona {
	//1 paradigma fondamentale = INCAPSULAMENTO
		public String nome;
		public String cognome;
		private int eta; 
		
		//costruttore, senza void, con tutti i parametri, diversa firma (overloading)
		public Persona(String n, String c, int e) { //non per forza devono avere gli stessi nomi 
			this.nome  = n; 
			this.cognome = c;
			this.setEta(e); 
		}
		
		//costruttore senza parametri
		public Persona() {
			
		}
		
		public void saluto() {
			System.out.println("Ciao sono " + this.nome + " ed il mio cognome è: " + this.cognome + " e la mia età è: " + this.eta);
		}
		
		//private vale solo per la classe per cui è creata
		
		
		//per far funzionare L'INCAPSULAMENTO devo mettere TUTTI gli attributi private e per controllarli si devono controllare questi dati attraverso GETTER E SETTER
		
		//SETTER controlla il dato se è buono lo assegna alla variabile, non restituisce niente
		//GETTER stampa e quindi restituire il valore, restituisce il valore i bae al tipo di dato 
		
		public void setEta(int etaPersona) {
			if(eta < 0 || etaPersona > 110) { //controllo 
				System.out.println("ETA SBAGLIATA");
				etaPersona = 0; //assegnazione
			}
			this.eta = etaPersona; // parametro = attributo; 		 
		}
		
		public int getEta() {
			return this.eta; 
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return this.nome; 
		}
		
		
}
