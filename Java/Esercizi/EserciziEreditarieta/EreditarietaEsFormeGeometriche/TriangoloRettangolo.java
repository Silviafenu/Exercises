package Lezione6EreditarietaEsFormeGeometriche;

public class TriangoloRettangolo extends FiguraGeometrica {
		private int l3;
		private int l4;
		
				
		
		public TriangoloRettangolo(int l, int l3, int l4) {
			super(l);
			this.l3 = l3;
			this.l4 = l4; 
		}
		
		//METODO GETTER 
		public int getL3() {
			return l3;
		}

		public int getL4() {
			return l4;
		}

		
		//METODO SETTER 
		public void setL3(int l3) {
			this.l3 = l3;
		}

		public void setL4(int l4) {
			this.l4 = l4;
		}

		
		   //metodi
		@Override
		public double calcolaPerimetro() {
			return (l3 + l4 + getL());
			
		}
		
		@Override
		public double calcolaArea() {
			return (l3*l4)/2;
		}
	}
		

