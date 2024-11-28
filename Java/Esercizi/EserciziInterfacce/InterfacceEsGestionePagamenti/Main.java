package Lezione7InterfacceEsGestionePagamenti;

public class Main {

	public static void main(String[] args) {
		IPagamento[] pagamenti = new IPagamento[3];
		pagamenti[0] = new CartaDiCredito("1234567", "Mario", 2005);
		pagamenti[1] = new BonificoBancario("IT1234567", "Lucia");
		pagamenti[2] = new Contanti(1350);
		
		for(int i = 0; i < pagamenti.length; i++) {
			pagamenti[i].effettuaPagamento(200.50);
		}
	}

}
