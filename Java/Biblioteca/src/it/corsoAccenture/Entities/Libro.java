package it.corsoAccenture.Entities;

public class Libro {
	private int id_Libro;
	private String titolo; 
	private String autore; 

	public Libro(int id_Libro, String titolo, String autore) {
		super(); 
		this.id_Libro = id_Libro; 
		this.titolo = titolo; 
		this.autore = autore; 
	}
	
	public Libro( String titolo, String autore) {
		super(); 
		this.titolo = titolo; 
		this.autore = autore; 
	}
	

	public int getId_Libro() {
		return id_Libro;
	}

	public void setId_Libro(int id_Libro) {
		this.id_Libro = id_Libro;
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

	@Override
	public String toString() {
		return "\n id_Libro=" + id_Libro + "\n titolo=" + titolo + "\n autore=" + autore ;
	}
	
	
}
