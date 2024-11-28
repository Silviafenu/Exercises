package it.corsoAccenture.Interfaces;

import java.util.List;

import it.corsoAccenture.Entities.Brani;

public interface BraniDAO {
	
	public void addBrani(Brani b);
	public List<Brani> readBrani(); 
	public void updateBrani(); 
	public void deleteBrani(); 

}
