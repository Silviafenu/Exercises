package Lezione6EreditarietaEsFormeGeometriche;

public class Rettangolo extends FiguraGeometrica {
	private int l2;

	//costruttore con parametri 
		
	public Rettangolo(int l, int l2) {
		super(l);
		this.l2 = l2; 
	}

	//metodo GETTER
	public int getL2() {
		return l2;
	}
	
	//METODO SETTER
	public void setL2(int l2) {
		this.l2 = l2;
	}

	   //metodi
		@Override
		public double calcolaPerimetro() {
			return (getL() + l2)*2;
		
		}
		
		@Override
		public double calcolaArea() {
			return getL()*l2;
		}
}
