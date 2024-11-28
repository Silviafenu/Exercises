package Lezione5Oggetti.EsercizioAuto;

public class EsAuto {

	public static void main(String[] args) {
		
		Auto a1 = new Auto("Fiat", "Panda", 20.550, true); 
		a1.stampaAuto();
		
		
		Auto a2 = new Auto();
		a2.setMarca("Audi");
		a2.setModello("e-tron GT");
		a2.setCosto(169.400);
		a2.setDisponibilita(true);
		a2.stampaAuto();
		 	
		
		Auto a3 = new Auto("Ami", 7.990);	
		a3.setMarca("Citroen");
		a3.setDisponibilita(false);
		a3.stampaAuto();
	}

}
