package Lezione6EreditarietaEsVeicoli;

public abstract class Veicolo {
	private String targa;
	private String modello;
	
	
	//costruttore con parametri
	public Veicolo(String targa, String modello) {
		this.targa = targa;
		this.modello = modello; 
	}

	//motodo GETTER
	public String getTarga() {
		return targa;
	}

	public String getModello() {
		return modello;
	}

	//METODO SETTER
	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
	
	//metodi
	public abstract double calcolaManutenzione();

	@Override
	public String toString() {
		return "\n Targa: " + this.targa + ",\n Modello=" + this.modello;
	}
	
	
	

	
	

}
