package Lezione7InterfacceEsGestionePagamenti;

public class BonificoBancario implements IPagamento {
	private String IBAN; 
	private String beneficiario; 
	
	//costruttore con parametri 
	public BonificoBancario(String IBAN, String beneficiario ) {
		super();
		this.IBAN = IBAN; 
		this.beneficiario = beneficiario; 
	}

	//metodo GETTER
	public String getIBAN() {
		return IBAN;
	}

	public String getBeneficiario() {
		return beneficiario;
	}
	
	//metodo SETTER
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	@Override
	public void effettuaPagamento(double importo) {
		System.out.println("Pagamento Effettuato con bonifico Bancario ");
	}
	
	
	
}
