package Lezione6EreditarietaEsVeicoli;

public class Main {

	public static void main(String[] args) {
		Veicolo[] veicoli = new Veicolo[3];
		
		veicoli[0] = new Auto("Ax3784", "Panda4x4", 4);
		veicoli[1] = new Camion("fg2932", "Bisarche",2000);
		veicoli[2] = new Moto("dh3388", "Ducati", 200);
		
		for(int i = 0; i < veicoli.length; i++) {
			System.out.println(veicoli[i].toString());	
		}
		
	}

}
