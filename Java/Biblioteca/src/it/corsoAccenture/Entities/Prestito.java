package it.corsoAccenture.Entities;

import java.time.LocalDate;

public class Prestito {
	private int id_Prestito; 
	private LocalDate dataInizio; 
	private LocalDate dataFine; 
	
	
	public Prestito(int id_Prestito, LocalDate dataInizio,LocalDate dataFine ) {
		this.id_Prestito = id_Prestito; 
		this.dataInizio = dataInizio; 
		this.dataFine = dataFine; 
	}


	public int getId_Prestito() {
		return id_Prestito;
	}


	public void setId_Prestito(int id_Prestito) {
		this.id_Prestito = id_Prestito;
	}


	public LocalDate getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}


	public LocalDate getDataFine() {
		return dataFine;
	}


	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}


	@Override
	public String toString() {
		return "\n id_Prestito=" + id_Prestito + "\n dataInizio=" + dataInizio + "\n dataFine=" + dataFine;
	}
	
	
	

}
