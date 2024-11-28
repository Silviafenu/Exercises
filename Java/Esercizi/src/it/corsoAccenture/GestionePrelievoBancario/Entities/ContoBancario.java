package it.corsoAccenture.GestionePrelievoBancario.Entities;

import java.util.Scanner;

import it.corsoAccenture.Eccezioni.ControlloSoldi;

public class ContoBancario{
	private static Scanner scan = new Scanner(System.in);

	private String nomeCliente; 
    private String cognomeCliente; 
    private double saldo; 
    
    public ContoBancario(String nomeCliente, String cognomeCliente, double saldo  ) {
    	super();
    	this.nomeCliente = nomeCliente; 
    	this.cognomeCliente = cognomeCliente;
    	this.saldo = saldo; 
    }
    
    public String getNomeCliente() {
    	return this.nomeCliente;
    }
    
    public String getCognomeCliente() {
    	return this.cognomeCliente;
    }
    
    public double getSaldo() {
    	return this.saldo;
    }
    
    public void setNomeCliente(String nomeCliente) {
    	this.nomeCliente = nomeCliente;
    	
    }
    
    public void setCognomeCliente(String cognomeCliente) {
    	this.cognomeCliente = cognomeCliente;    	
    }
    
    public void setSaldo(double saldo) {
    	this.saldo = saldo;    	
    }
    
    public void prelievo(double importo) throws ControlloSoldi {
    	if(importo > saldo) {
    		throw new ControlloSoldi("Importo maggiore del saldo disponibile");
    	}
    		this.saldo -= importo; 
    		System.out.println("Denaro prelevato, saldo attuale: " + this.saldo);
    	
    }
    
    public void deposito(int importo){
        	this.saldo += importo; 
        	System.out.println("Denaro dpeositato, saldo attuale: " + this.saldo);
    	
    }

	@Override
	public String toString() {
		return "\n nome Cliente: " + nomeCliente + ", \n cognome Cliente=" + cognomeCliente + ", \n saldo: " + saldo;
	}
    
    
}
