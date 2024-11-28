package it.corsoAccenture.GestioneOrdini.Entities;

import java.util.HashMap;

public class GestioneOrdini {
	HashMap<Integer, Ordine> gestioneOrdini =new HashMap<Integer, Ordine>();

	public void aggiungiNuoviOrdini(Ordine ordine) {
		
		gestioneOrdini.put(ordine.getIdOrdine(), ordine);
		
		System.out.println(gestioneOrdini.get(ordine.getIdOrdine()).toString());
	}
	
	public void cercaOrdine(int ID) {
		if(gestioneOrdini.containsKey(ID)) {
			System.out.println("Ordine trovato" + gestioneOrdini.get(ID));
		}
		else {
			System.out.println("Ordine non trovato");
		}
	}
	
	public void aggiornaStatoOrdine(int ID2) {
		if(gestioneOrdini.containsKey(ID2)) {
			if(gestioneOrdini.get(ID2).getStato().equals("In elaborazione")) {
				System.out.println("Spedito");
				gestioneOrdini.get(ID2).setStato("Spedito");
			}
			else if(gestioneOrdini.get(ID2).getStato().equals("Spedito")) {
				System.out.println("Consegnato");
				gestioneOrdini.get(ID2).setStato("Consegnato");
			}
		}
	}
	
	public void rimuovereOrdine(int ID3) {
		if(gestioneOrdini.containsKey(ID3)) {
			gestioneOrdini.remove(ID3);
			System.out.println("Ordine rimosso" + gestioneOrdini.get(ID3));
		}
	}
	
	public void stampaOrdini() {
		for(Integer id : gestioneOrdini.keySet()) {
			System.out.println(gestioneOrdini.get(id));
		}
	}
	
}

