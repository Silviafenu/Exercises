package Lezione8ListeEsMuseo;

abstract class Opera {
	private int codice;
	private String titolo; 
	private String autore;
	private boolean esposta = false; 
	
	public Opera(int codice, String titolo, String autore,  boolean esposta  ) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.autore = autore;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public boolean isEsposta() {
		return esposta;
	}

	public void setEsposta(boolean esposta) {
		this.esposta = esposta;
	}

	@Override
	public String toString() {
		return "\n Codice:" + codice + ", \n titolo = " + titolo + ", \n autore = " + autore;
	}
	
	
	
}
