package it.corsoAccenture.Entities;

public class Genere {
	private int id_brano;
	private String nomeGenere;
	
	public Genere(int id_brano, String nomeGenere ) {
		this.id_brano = id_brano; 
		this.nomeGenere = nomeGenere; 
	}

	public int getId_brano() {
		return id_brano;
	}

	public void setId_brano(int id_brano) {
		this.id_brano = id_brano;
	}

	public String getNomeGenere() {
		return nomeGenere;
	}

	public void setNomeGenere(String nomeGenere) {
		this.nomeGenere = nomeGenere;
	}

	@Override
	public String toString() {
		return "\n id_brano:" + id_brano + "\n nomeGenere:" + nomeGenere ;
	}
	
	

}
