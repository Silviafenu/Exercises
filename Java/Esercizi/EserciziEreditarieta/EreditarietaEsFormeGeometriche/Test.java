package Lezione6EreditarietaEsFormeGeometriche;

public class Test {

	public static void main(String[] args) {
		FiguraGeometrica[] figure = new FiguraGeometrica[3];
		
		figure[0] = new Quadrato(4); 
		figure[1] = new Rettangolo(3,2);
		figure[2] = new TriangoloRettangolo(5,6,7);
		
		for(int i = 0; i < figure.length; i++) {
			System.out.println("Il perimetro è: " + figure[i].calcolaPerimetro());
			System.out.println("L'area è: " + figure[i].calcolaArea());
		}
		
		
	}

}
