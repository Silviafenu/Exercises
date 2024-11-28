package Lezione8ListeEsMuseo;

public class Quadri extends Opera {
	private String tecnicaUsata;
	
	public Quadri(int codice, String titolo, String autore,  boolean esposta, String tecnicaUsata  ) {
		super(codice,titolo, autore,esposta);
		this.tecnicaUsata = tecnicaUsata;
	}

	public String getMateriale() {
		return tecnicaUsata;
	}

	public void setMateriale(String materiale) {
		this.tecnicaUsata = materiale;
	}

	@Override
	public String toString() {
		return "\n Quadro: " + super.toString() + " \n tecnicaUsata " + tecnicaUsata;
	}
	
	

}
