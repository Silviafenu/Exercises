package it.corsoAccenture.Libreria.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro implements Serializable {
	private String titolo;
	private String autore; 
	private transient double prezzo; //non serializza il prezzo, NON si vede
	private LocalDate dataUscita; 
	
	public Libro(String titolo, String autore, double prezzo, LocalDate dataUscita) {
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo; 
		this.dataUscita = dataUscita; 
	}
	
	public String getTitolo() {
		return this.titolo; 
	}
	
	public String getAutore() {
		return this.autore;
	}
	
	public double getPrezzo() {
		return this.prezzo; 
	}

	public LocalDate getDataUscita() {
		return this.dataUscita;
	}
	
	public void setTitolo() {
		this.titolo = titolo; 
	}
	
	public void setAutore() {
		this.autore = autore; 
	}
	
	public void setPrezzo() {
		this.prezzo = prezzo; 
	}
	
	public void setDataUscita() {
		this.dataUscita = dataUscita; 
	}

	public String formatoData() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formato.format(this.dataUscita); 
	}
	@Override
	public String toString() {
		return "\n titolo: " + titolo + ", \n autore: " + autore + ",\n prezzo: " + prezzo + ", \n data uscita: " + formatoData();
	}
	
	
}


