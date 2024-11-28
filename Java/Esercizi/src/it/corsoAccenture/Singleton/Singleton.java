package it.corsoAccenture.Singleton;

public class Singleton {
	//attributo privato 
private static Singleton instance = null; 

//costruttore privato 
private Singleton() {
	super(); 
}

//metodo pubblico che mi restituisce l'istanza
public static Singleton getIstance() {
	if(instance == null) {
		instance = new Singleton(); 
	}
	return instance;
}
}
