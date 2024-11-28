package Lezione7InterfacceEsGestionePagamenti;

public class CartaDiCredito implements IPagamento{
	private String numeroCarta; 
	private String intestazione; 
	private int annoScadenza;
	
	//costruttore con parametri 
	   public CartaDiCredito(String numeroCarta, String intestazione, int annoScadenza) {
		   super();
	        this.numeroCarta = numeroCarta;
	        this.intestazione = intestazione;
	        this.annoScadenza = annoScadenza;
	    }

	   //metodo GETTER
	public String getNumeroCarta() {
		return numeroCarta;
	}

	public String getIntestazione() {
		return intestazione;
	}

	public int getAnnoScadenza() {
		return annoScadenza;
	}

	//metodo SETTER
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public void setIntestazione(String intestazione) {
		this.intestazione = intestazione;
	}

	public void setAnnoScadenza(int annoScadenza) {
		this.annoScadenza = annoScadenza;
	}

	@Override
	public void effettuaPagamento(double importo) {
		System.out.println("Pagamento Effettuato con carta di Credito ");
	}
	
	
	

}
