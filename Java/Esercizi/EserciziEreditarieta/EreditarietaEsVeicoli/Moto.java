package Lezione6EreditarietaEsVeicoli;

public class Moto extends Veicolo {
		private int cilidrata;
				
		//costruttore con i parametri
			public Moto(String targa, String modello, int cilidrata) {
				super(targa, modello);
				this.cilidrata = cilidrata;
			}
			
			//metodo Getter
			public int getccilidrata() {
				return cilidrata;
			}

			//Metodo Setter
			public void setNumeroPorte(int cilidrata) {
				this.cilidrata = cilidrata;
			}
			

			//metodi
			@Override
			public double calcolaManutenzione() {
				return (2000 + (cilidrata * 0.1));
			}

			@Override
			public String toString() {
				return " \n Moto:"  + super.toString() +"\n Manutenzione: " +  calcolaManutenzione() ;
			}
			
			
}
