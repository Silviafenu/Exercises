package it.corsoAccenture.GestioneOrdini.Entities;

public class Ordine {
	private int idOrdine; 
	private String cliente;
	private String dataOrdine; 
	private double importoTotale;
	private String stato;
	
	public Ordine(int idOrdine,String cliente, String dataOrdine, double importoTotale, String stato) {
		super();
		this.idOrdine = idOrdine;
		this.cliente = cliente;
		this.dataOrdine = dataOrdine;
		this.importoTotale = importoTotale;
		this.stato = stato; 
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public double getImportoTotale() {
		return importoTotale;
	}

	public void setImportoTotale(double importoTotale) {
		this.importoTotale = importoTotale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "\n idOrdine = " + idOrdine + ", \n cliente = " + cliente + ", \n data ordine = " + dataOrdine
				+ ",\n importoTotale = " + importoTotale + ",\n stato = " + stato ;
	}
	
	
	
}