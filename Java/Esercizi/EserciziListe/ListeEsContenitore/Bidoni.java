package Lezione8ListeEsContenitore;

public class Bidoni extends Contenitore{
	
	public Bidoni(int codice,String nome,double quantita) {
		super(codice,nome,quantita);
	}

	@Override
	public Double confronta(Contenitore c) {
		if(c instanceof Bidoni ) {
			return (this.getQuantita() - ((Bidoni) c).getQuantita());
		}
		else {
			return null;
		}	
		
	}
	
}
