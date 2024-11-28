package Lezione8ListeEsMuseo;

public class Statue extends Opera {
	private String materiale;
	private double altezza;
	
	public Statue(int codice, String titolo, String autore,  boolean esposta, String materiale, double altezza  ) {
		super(codice,titolo, autore,esposta);
		this.materiale = materiale;
		this.altezza = altezza; 
	}

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	@Override
	public String toString() {
		return "\n Statue: " + super.toString() + "\n materiale: " + materiale + "\n altezza: " + altezza;	
		}
	

}
