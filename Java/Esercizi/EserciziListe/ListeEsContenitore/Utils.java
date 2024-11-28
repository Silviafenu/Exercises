package Lezione8ListeEsContenitore;
import java.util.ArrayList;

public class Utils {
	
	public Contenitore[] filtra(Contenitore[] T, Contenitore c) {

		for(int i = 0; i < T.length; i++) {
			//cerco se NON hanno nome uguale
			if( T[i] != null && !T[i].getNome().equals(c.getNome())) {
				System.out.println("\n Codice: " + T[i].getCodice());
				System.out.println("\n Nome: " + T[i].getNome());
				System.out.println("\n Quatita: " + T[i].getQuantita());
			}
		}
		return T;
		
	}

}
