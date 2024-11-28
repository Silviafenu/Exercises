package Lezione5Oggetti.EsercizioAuto;
import java.util.Scanner;

public class Auto {
    private String marca;
    private String modello;
    private double costo;
    private boolean disponibilita;

    //costruttore con i parametri 
    public Auto(String marca, String modello, double costo, boolean disponibilita) {
    	super();
        this.marca = marca;
        this.modello = modello;
        this.costo = costo;
        this.disponibilita = disponibilita;
    }
    
    //costruttore senza parametri 
    public Auto() {
    	super();
    }
    
    //3 costrutture con 2 parametri
    public Auto(String modello, double costo) {
    	  super();
    	  this.modello = modello;
          this.costo = costo;
    }
    
    //metodo SETTER
    public void setMarca(String marca) {
    	this.marca = marca; 
    }
    
    public void setModello(String modello) {
    	this.modello = modello;
    }
    
    public void setCosto (double costoMacchina) {
    	Scanner scan = new Scanner(System.in);
    	//controllo il costo della macchina
    do {
    	System.out.println("ERRORE! inserisci di nuovo il dato: ");
    	costoMacchina = scan.nextInt(); 
    }
    while(costoMacchina < 0 || costoMacchina > 150000);
    
    	this.costo = costoMacchina; 
    	
    	scan.close();
    }
    public void setDisponibilita (boolean disponibilita) {
    	this.disponibilita = disponibilita; 
    }
    
    //metdo GETTER
    public String marca() {
    	return this.marca;
    }
    
    public String modello() {
    	return this.modello;
    }
    
    public double costo() {
    	return this.costo;
    }
    
    public boolean disponibilita() {
    	return this.disponibilita;
    }
    
    public void stampaAuto() {
    	System.out.println("Le caratterisitiche sono: \n marca: " + this.marca + "\n modello: " + this.modello + "\n costo: " + this.costo + "\n disponibilita: " + this.disponibilita); 
    	
    }
    
  
    
}