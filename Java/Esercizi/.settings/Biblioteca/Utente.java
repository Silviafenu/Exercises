package it.corsoAccenture.Biblioteca;

public class Utente {
	private int IDutente; 
	private String nome; 
	private String cognome;
	private int eta;
	
	public Utente (int IDutente, String nome, String cognome, int eta) {
		super();
		this.IDutente = IDutente; 
		this.nome = nome; 
		this.cognome = cognome;
		this.eta = eta; 
	}

	public int getIDutente() {
		return IDutente;
	}

	public void setIDutente(int iDutente) {
		IDutente = iDutente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "\n ID utente: "+ IDutente + " \n nome: " + nome + ", \n cognome: " + cognome + ",\n eta: " + eta ;
	}
	

}
