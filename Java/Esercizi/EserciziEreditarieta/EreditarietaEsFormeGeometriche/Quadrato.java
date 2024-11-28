package Lezione6EreditarietaEsFormeGeometriche;

public class Quadrato extends FiguraGeometrica {

	//costruttore con parametri 
	public Quadrato(int l) {
		super(l);
	}
	
    //metodi
	@Override
	public double calcolaPerimetro() {
		return getL()*4;
	}
	
	@Override
	public double calcolaArea() {
		return getL()*getL();
	}

	

}
