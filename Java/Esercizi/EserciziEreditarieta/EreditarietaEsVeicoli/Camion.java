package Lezione6EreditarietaEsVeicoli;

public class Camion extends Veicolo {
	private int capacitaCarico; 
	
	//costruttore con i parametri
		public Camion(String targa, String modello, int capacitaCarico) {
			super(targa, modello);
			this.capacitaCarico = capacitaCarico;
		}
		
		//metodo Getter
		public int getcapacitaCarico() {
			return capacitaCarico;
		}

		//Metodo Setter
		public void setNumeroPorte(int capacitaCarico) {
			this.capacitaCarico = capacitaCarico;
		}
		

		//metodi
		@Override
		public double calcolaManutenzione() {
			return (500 + (capacitaCarico * 2));
		}
		@Override
		public String toString() {
			return " \n Camion:"  + super.toString() +"\n Manutenzione: " +  calcolaManutenzione() ;
		}
		
		
		
}
