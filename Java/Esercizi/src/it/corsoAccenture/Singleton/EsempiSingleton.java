package it.corsoAccenture.Singleton;

public class EsempiSingleton {
	public static void main(String[] args) {
		
		Singleton s1= Singleton.getIstance();
		
		Singleton s2 = Singleton.getIstance();
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
