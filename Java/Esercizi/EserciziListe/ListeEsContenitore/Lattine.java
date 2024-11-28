package Lezione8ListeEsContenitore;

public class Lattine extends Contenitore {

	public Lattine(int codice, String nome, double quantita) {
		super(codice,nome,quantita);
	}

	@Override
	public Double confronta(Contenitore c) {
		if(c instanceof Lattine ) {
			return (this.getQuantita() - ((Lattine) c).getQuantita());
		}
		else {
			return null;
		}		
	}
	
}
