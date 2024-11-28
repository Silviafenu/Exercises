package Lezione6EreditarietaEsFormeGeometriche;

public abstract class FiguraGeometrica {
	private int l;
	
	//costruttore con parametri 
	public FiguraGeometrica(int l) {
		this.l = l; 		
	}
	
	//Metodo GETTER
	public int getL() {
		return l;
	}

	//Metodo SETTER
	public void setL(int l) {
		this.l = l;
	}
	
	//metodi
	public abstract double calcolaPerimetro();
	
	public abstract double calcolaArea();
	
	
	

}
