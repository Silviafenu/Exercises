package it.corsoAccenture.Eccezioni;

public class ControlloSoldi extends RuntimeException {
	public ControlloSoldi() {
		super("ERRORE"); 
	}
	
	public ControlloSoldi(String message) {
		super(message); 
	}

}
