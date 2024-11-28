package Lezione6EreditarietaEsVeicoli;

public class Auto extends Veicolo{
	private int numeroPorte; 

	//costruttore con i parametri
	public Auto(String targa, String modello, int numeroPorte) {
		super(targa, modello);
		this.numeroPorte = numeroPorte;
	}
	
	//metodo Getter
	public int getNumeroPorte() {
		return numeroPorte;
	}

	//Metodo Setter
	public void setNumeroPorte(int numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	//metodi
	@Override
	public double calcolaManutenzione() {
		return (300 + (numeroPorte * 50));
	}
	@Override
	public String toString() {
		return " \n Auto:"  + super.toString() +"\n Manutenzione: " +  calcolaManutenzione() ;
	}
	
	
}
