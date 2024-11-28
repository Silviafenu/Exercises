package Lezione8ListeEsMuseo;
import java.util.ArrayList;
import java.util.List;

public class Museo {
	private static final int NUM_MAX_OPERESPOSTE = 10;
	
	private List<Opera> opereEsposte = new ArrayList<Opera>();
	private List<Opera> deposito = new ArrayList<Opera>();
	
	public void carica(Opera opera) {
		if(opereEsposte.size() > NUM_MAX_OPERESPOSTE) {
			opera.setEsposta(false); //setto che non è visibile
			deposito.add(opera); //aggiunta al deposito
			System.out.println("Opera all'interno del depostio");
		}
		else {
			opera.setEsposta(true); //setto che è visibile
			opereEsposte.add(opera); //aggiunta all'esposizione
			System.out.println("Opera esposta");
		}
	}
	
	public Opera cerca(int codice) {
		for(int i = 0; i < opereEsposte.size(); i++) {
			//cerco l'opera nelle opere esposte
			if(opereEsposte.get(i).getCodice() == codice) {
				return opereEsposte.get(i);
				
			}
		}
			//cerco l'opera nel deposito
		for(int i = 0; i < deposito.size(); i++) {
			if(deposito.get(i).getCodice() == codice) {
				return deposito.get(i);
			}
		}
		return null;		
	}
	
	public Opera sposta(int codice) {
		Opera opera = cerca(codice);
		
		if(opera != null && opereEsposte.contains(opera)) {
			opereEsposte.remove(opera);
			deposito.add(opera);
			System.out.println("Opera spostata nel deposito");
		}
		else {
			System.out.println("Opera già presente nel deposito");
		}
		return opera; 
		
		
	}
	
	public void stampaSala() {
		System.out.println("\n Le opere esposte sono: ");
		for(int i = 0; i < opereEsposte.size(); i++) {
			System.out.println(opereEsposte.get(i).toString());
		}		
	}
	
	public void stampaDeposito() {
		System.out.println("\n Le opere nel deposito sono: ");
		for(int i = 0; i < deposito.size(); i++) {
			System.out.println(deposito.get(i).toString());
		}	
	}
	
	
	

}
