package Lezione7InterfacceEsGestionePagamenti;

public class Contanti implements IPagamento {
	private double importo;
	
	//costruttore con parametri 
	public Contanti(double importo) {
		super();
		this.importo = importo;
	}

	//metodo GETTER
	public double getImporto() {
		return importo;
	}

	//metodo SETTER
	public void setImporto(double importo) {
		this.importo = importo;
	}

	@Override
	public void effettuaPagamento(double importo) {
			System.out.println("Pagamento Effettuato con contanti");
	} 
	
	
	

}
