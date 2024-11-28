package it.corsoAccenture.Pinocchio.Entities;

import java.io.Serializable;

public class Gatto implements Serializable {
	private String nome;
	private String razza;
	private int anni; 
	
	public Gatto(String nome, String razza, int anni) {
		this.nome = nome; 
		this.razza = razza;
		this.anni = anni; 
	}


	public String getNome() {
		return this.nome;
	}
	
	public String getRazza() {
		return this.razza; 
	}

	public int getAnni() {
		return this.anni; 
	}
	
	public void setNome(String nome) {
		this.nome = nome; 
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public void setAnni(int anni) {
		this.anni = anni;
	}

	@Override
	public String toString() {
		return "\n nome: " + nome + ",\n razza: " + razza + ",\n anni: " + anni ;
	}
	
	
}
