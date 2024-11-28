package Lezione8ListeEsContenitore;

abstract class Contenitore implements IConfronta {
	private int codice;
	private String nome;
	private double quantita;
	
	public Contenitore(int codice,String nome,double quantita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.quantita = quantita; 
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantita() {
		return quantita;
	}

	public void setQuantita(double quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public Double confronta(Contenitore c) {
		return null;
		
	}
	
}
