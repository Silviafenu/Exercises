package it.corsoAccenture.Entities;

public class Brani {
	private int id_brano;
	private String nomeAutore;
	private String titolo; 
	
	public Brani(int id_brano, String nomeAutore, String titolo) {
		super(); 
		this.id_brano = id_brano;
		this.nomeAutore = nomeAutore; 
		this.titolo = titolo; 
	}

	public int getId_brano() {
		return id_brano;
	}

	public void setId_brano(int id_brano) {
		this.id_brano = id_brano;
	}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "\n id_brano:" + id_brano + "\n nomeAutore:" + nomeAutore + "\n titolo:" + titolo;
	}
	
	
}
