package Lezione8ListeEsContenitore;

public class Main {

	public static void main(String[] args) {
		Lattine lattina1 = new Lattine(123, "SEVEN UP", 3.5); 
		Bidoni bidone1 = new Bidoni(324, "Plastica", 7.5);
		Lattine lattina2 = new Lattine(572, "Pepsi", 4.5);
		Bidoni bidone2 = new Bidoni(198, "Secco", 9.5);
		Lattine lattina3  = new Lattine(476, "coca cola", 6.5); 

		double differenza = lattina1.confronta(lattina2);
		double differenza2 = lattina2.confronta(lattina3);
		double differenza3 = bidone1.confronta(bidone2);
		System.out.println("differenza tra lattina 1 e lattina 2 :" + differenza);
		System.out.println("differenza tra lattina 2 e lattina 3 :" + differenza2);
		System.out.println("differenza tra bidone 1 e bidone 2 :" + differenza3);
		
		


				
	
	}

}
